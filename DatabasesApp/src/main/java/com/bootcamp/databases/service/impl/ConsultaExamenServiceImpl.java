package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.repository.ConsultaExamenRepository;
import com.bootcamp.databases.service.ConsultaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaExamenServiceImpl implements ConsultaExamenService {

    @Autowired
    private ConsultaExamenRepository consultaExamenRepository;

    @Override
    public ConsultaExamen registrar(ConsultaExamen consultaExamen) throws Exception {
        return consultaExamenRepository.save(consultaExamen);
    }

    @Override
    public ConsultaExamen modificar(ConsultaExamen consultaExamen) throws Exception {
        return consultaExamenRepository.save(consultaExamen);
    }

    @Override
    public void eliminar(int id) throws Exception {
        consultaExamenRepository.deleteById(id);
    }

    @Override
    public ConsultaExamen listarPorId(int id) throws Exception {
        Optional<ConsultaExamen> consultaExamen = consultaExamenRepository.findById(id);
        return consultaExamen.orElseThrow(() -> new Exception("La relación Consulta-Examen no existe."));
    }

    @Override
    public List<ConsultaExamen> listarTodos() throws Exception {
        return consultaExamenRepository.findAll();
    }
}
