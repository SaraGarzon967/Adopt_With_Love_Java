package com.app.adoptwithlove.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.adoptwithlove.Dto.AnimalDTO;
import com.app.adoptwithlove.Dto.AnimalResponseDTO;
import com.app.adoptwithlove.entity.Animal;
import com.app.adoptwithlove.entity.Fundacion;
import com.app.adoptwithlove.entity.Persona;
import com.app.adoptwithlove.repository.AnimalesRepository;
import com.app.adoptwithlove.repository.FundacionRepository;
import com.app.adoptwithlove.repository.PersonaRepository;
import com.app.adoptwithlove.service.AnimalService;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService service;

    @Autowired
    private FundacionRepository fundacionRepository;

    
    @Autowired
    private PersonaRepository personaRepository;

     @Autowired
    private AnimalesRepository animalesRepository;

    @GetMapping("/api/animales")
    @ResponseBody
    public List<Animal> listarAnimales() {
        return service.getAll();
    }

    @GetMapping("/mis-animales")
    @ResponseBody
    public ResponseEntity<List<AnimalResponseDTO>> getAnimalesFundacionAutenticada() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Persona persona = personaRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));
        Fundacion fundacion = fundacionRepository.findByPersona_Id(persona.getId())
            .orElseThrow(() -> new RuntimeException("Fundación no encontrada"));

        List<Animal> animales = animalesRepository.findByFundacion(fundacion);

        List<AnimalResponseDTO> respuesta = animales.stream()
            .map(AnimalResponseDTO::new)
            .toList();

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/editar/{id}")
    @ResponseBody
    public ResponseEntity<AnimalResponseDTO> obtenerAnimalPorId(@PathVariable Long id) {
        Animal animal = animalesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal no encontrado con ID: " + id));

        AnimalResponseDTO dto = new AnimalResponseDTO(animal);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/editar/{id}")
    @ResponseBody
    public ResponseEntity<?> editarAnimal(@PathVariable Long id, @RequestBody AnimalDTO dto) {
        Animal existente = animalesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal no encontrado con ID: " + id));

        existente.setNombre(dto.getNombre());
        existente.setEdad(dto.getEdad());
        existente.setRaza(dto.getRaza());
        existente.setTipo_animal(dto.getTipo_animal());
        existente.setImagen(dto.getImagen());

        animalesRepository.save(existente);
        return ResponseEntity.ok("Animal actualizado correctamente");
    }

    @GetMapping("/animal")
    public String getAll(Model modelo){
        modelo.addAttribute("animales", service.getAll());
        return "animal";
    }

    @GetMapping("animal/nuevo")
    public String show(Model modelo){
        Animal animal = new Animal();
        modelo.addAttribute("animal", animal);
        return "animalCreate";
    }

    @PostMapping("/animal")
    public String create(@ModelAttribute("animal") Animal animal, Model model){
        service.create(animal);
        return "redirect:/animal";
    }


    @PostMapping("/animal/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("animal") Animal animal ){
        Animal animalExistente = service.getById(id);
        animalExistente.setId(id);
        animalExistente.setTipo_animal(animal.getTipo_animal());
        animalExistente.setEdad(animal.getEdad());
        animalExistente.setNombre(animal.getNombre());
        animalExistente.setRaza(animal.getRaza());
        animalExistente.setAdopciones(animal.getAdopciones());
        animalExistente.setFundacion(animal.getFundacion());
        service.update(id,animalExistente);
        return "redirect:/animal";
    }

    @DeleteMapping("/eliminar/{id}")
public ResponseEntity<?> eliminarAnimal(@PathVariable Long id) {
    animalesRepository.deleteById(id);
    return ResponseEntity.ok().build();
}

@GetMapping("/catalogo")
public List<AnimalDTO> obtenerCatalogoFundacion(@AuthenticationPrincipal UserDetails userDetails) {
    String email = userDetails.getUsername();

    Persona fundacion = personaRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Fundación no encontrada con el email: " + email));

    List<Animal> animales = service.getByFundacion(fundacion.getId());

    return animales.stream()
            .map(a -> new AnimalDTO(
                    a.getId(),
                    a.getNombre(),
                    a.getEdad(),
                    a.getRaza(),
                    a.getTipo_animal(),
                    a.getImagen()
            ))
            .collect(Collectors.toList());
}


    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<?> crearAnimal(@RequestBody AnimalDTO dto) {
        try {
            String email = SecurityContextHolder.getContext().getAuthentication().getName();
            Persona persona = personaRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + email));
            Fundacion fundacion = fundacionRepository.findByPersona_Id(persona.getId())
                    .orElseThrow(() -> new RuntimeException("Fundación no encontrada"));
            Animal animal = new Animal();
            animal.setNombre(dto.getNombre());
            animal.setEdad(dto.getEdad());
            animal.setRaza(dto.getRaza());
            animal.setTipo_animal(dto.getTipo_animal());
            animal.setImagen(dto.getImagen()); // solo si estás manejando imagen como base64 o URL
            animal.setFundacion(fundacion);

            Animal guardado = animalesRepository.save(animal);
            return ResponseEntity.ok(guardado);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    


}
