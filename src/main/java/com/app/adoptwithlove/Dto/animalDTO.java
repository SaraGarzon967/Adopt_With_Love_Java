package com.app.adoptwithlove.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class animalDTO {
    private  Long id;
    private String nombre;
    private Integer edad;
    private String raza;
    private String tipo_animal;
}
