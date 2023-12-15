package com.bootcamp.databases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Examen {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(name = "nombre", nullable = false, length = 100)
	    private String nombre;

	    @Column(name = "descripcion", length = 255)
	    private String descripcion;

	    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<ConsultaExamen> consultaExamenes;


}
