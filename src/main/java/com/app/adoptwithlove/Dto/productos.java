package com.app.adoptwithlove.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class productos {
    private  Long id;
    private String nombre;
    private String precio;
    private String tipoProducto;
}
