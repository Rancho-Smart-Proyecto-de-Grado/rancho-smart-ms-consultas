package com.rancho_smart.ms_consultas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_consultas.entity.Consulta;
import com.rancho_smart.ms_consultas.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaRESTController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.getAllConsultas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) {
        return consultaService.getConsultaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tratamiento/{idTratamiento}")
    public ResponseEntity<List<Consulta>> getConsultasByIdTratamiento(@PathVariable Long idTratamiento) {
        List<Consulta> consultas = this.consultaService.getConsultasByIdTratamiento(idTratamiento);
        if (consultas != null && !consultas.isEmpty()) {
            return ResponseEntity.ok(consultas);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/historial/{idHistorialMedico}")
    public ResponseEntity<List<Consulta>> getConsultasByIdHistorialMedico(@PathVariable Long idHistorialMedico) {
        List<Consulta> consultas = this.consultaService.getConsultasByIdHistorial(idHistorialMedico);
        if (consultas != null && !consultas.isEmpty()) {
            return ResponseEntity.ok(consultas);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta) {
        return consultaService.createConsulta(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @RequestBody Consulta consultaDetails) {
        return consultaService.updateConsulta(id, consultaDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        if (consultaService.deleteConsulta(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}