package com.demoblaze.models;

import lombok.*;

@Data
@Builder
public class DatosClienteModel {

    private String nombre;
    private String pais;
    private String ciudad;
    private String tarjeta;
    private String mes;
    private String anio;
}