package com.demoblaze.hooks;

import com.demoblaze.models.DatosClienteModel;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableDefinitions {

    @DataTableType
    public DatosClienteModel datosClienteEntryTransformer(Map<String, String> entry) {

        return DatosClienteModel.builder()
                .nombre(entry.get("nombre"))
                .pais(entry.get("pais"))
                .ciudad(entry.get("ciudad"))
                .tarjeta(entry.get("tarjeta"))
                .mes(entry.get("mes"))
                .anio(entry.get("anio"))
                .build();
    }
}
