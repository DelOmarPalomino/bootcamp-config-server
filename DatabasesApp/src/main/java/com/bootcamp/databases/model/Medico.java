package com.bootcamp.databases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
/*@Getter
@Setter
@ToString
@EqualsAndHashCode*/
//@Table(name = "tbl_Medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;
	
	@Column(name = "nombres", nullable = false, length = 100)
	private String nombres;
	@Column(name = "apellidos", nullable = false, length = 150)
	private String apellidos;
	@Column(name = "cmp", nullable = false, unique = true)
	private String cmp;
	@Column(name = "dni", nullable = false, length = 8, unique = true)
	private String dni;

	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Consulta> consultas;

}
