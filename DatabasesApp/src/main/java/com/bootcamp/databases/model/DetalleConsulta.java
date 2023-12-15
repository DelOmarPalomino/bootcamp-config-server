package com.bootcamp.databases.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "detalleConsulta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetalleConsulta {
    
    @Id
    private String id; 
    
    @Field("diagnostico")
    private String diagnostico;

    @Field("tratamiento")
    private String tratamiento;

    @Field("consulta_id")
    private int idConsulta;
    
    public String getId() {
        return this.id;
    }


}
