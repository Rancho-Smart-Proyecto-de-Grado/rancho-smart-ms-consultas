package com.rancho_smart.ms_consultas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_consultas.entity.Consulta;
import com.rancho_smart.ms_consultas.repository.ConsultaRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> getConsultaById(Long id) {
        return consultaRepository.findById(id);
    }

    public Consulta createConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Optional<Consulta> updateConsulta(Long id, Consulta consultaDetails) {
        return consultaRepository.findById(id)
            .map(consulta -> {
                consulta.setDiagnostico(consultaDetails.getDiagnostico());
                consulta.setFechaConsulta(consultaDetails.getFechaConsulta());
                consulta.setComentarios(consultaDetails.getComentarios());
                return consultaRepository.save(consulta);
            });
    }

    public boolean deleteConsulta(Long id) {
        return consultaRepository.findById(id)
            .map(consulta -> {
                consultaRepository.delete(consulta);
                return true;
            }).orElse(false);
    }
}