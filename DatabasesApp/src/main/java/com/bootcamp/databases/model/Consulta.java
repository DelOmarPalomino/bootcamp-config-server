package com.bootcamp.databases.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Consulta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;
    
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    @Transient
    private List<String> detallesConsultaIds;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "consulta_examen",
        joinColumns = @JoinColumn(name = "consulta_id"),
        inverseJoinColumns = @JoinColumn(name = "examen_id")
    )
    private List<Examen> examenes;

    
    public void setDetallesConsultaIds(List<String> detallesConsultaIds) {
        this.detallesConsultaIds = detallesConsultaIds;
    }


}
