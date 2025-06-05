package com.app.adoptwithlove.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class fundacionDTO {
    private  Long id;
    private String nombre_fundacion;
    private String direccion;
    private String correo;
    private String telefono;
}
