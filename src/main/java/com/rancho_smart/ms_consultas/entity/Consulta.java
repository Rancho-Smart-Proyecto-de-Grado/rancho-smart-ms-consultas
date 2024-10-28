package com.rancho_smart.ms_consultas.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false, name = "ID_HISTORIAL_MEDICO")
    private Long idHistorialMedico;
    
    @Column(name = "ID_TRATAMIENTO")
    private Long idTratamiento;

    @Column(nullable = false, name = "DIAGNOSTICO")
    private String diagnostico;

    @Column(nullable = false, name = "FECHA_CONSULTA")
    private LocalDate fechaConsulta;

    @Column(name = "COMENTARIOS")
    private String comentarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Long getIdHistorialMedico() {
        return idHistorialMedico;
    }

    public void setIdHistorialMedico(Long idHistorialMedico) {
        this.idHistorialMedico = idHistorialMedico;
    }

    public Long getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Long idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Consulta() {}

    public Consulta(Long idHistorialMedico, Long idTratamiento, String diagnostico, LocalDate fechaConsulta,
            String comentarios) {
        this.idHistorialMedico = idHistorialMedico;
        this.idTratamiento = idTratamiento;
        this.diagnostico = diagnostico;
        this.fechaConsulta = fechaConsulta;
        this.comentarios = comentarios;
    }
   
}
