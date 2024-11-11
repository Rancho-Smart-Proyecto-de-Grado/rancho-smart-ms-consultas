package com.rancho_smart.ms_consultas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_consultas.entity.Consulta;
import java.util.List;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    public List<Consulta> findByIdTratamiento(Long idTratamiento);
    public List<Consulta> findByIdHistorialMedico(Long idHistorialMedico);
}
