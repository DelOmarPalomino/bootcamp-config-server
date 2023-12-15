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
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspecialidad;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Consulta> consultas;

}
