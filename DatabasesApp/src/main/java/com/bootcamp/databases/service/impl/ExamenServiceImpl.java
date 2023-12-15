package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.repository.ExamenRepository;
import com.bootcamp.databases.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public Examen registrar(Examen examen) throws Exception {
        return examenRepository.save(examen);
    }

    @Override
    public Examen modificar(Examen examen) throws Exception {
        return examenRepository.save(examen);
    }

    @Override
    public void eliminar(int id) throws Exception {
        examenRepository.deleteById(id);
    }

    @Override
    public Examen listarPorId(int id) throws Exception {
        Optional<Examen> examen = examenRepository.findById(id);
        return examen.orElseThrow(() -> new Exception("El examen no existe."));
    }

    @Override
    public List<Examen> listarTodos() throws Exception {
        return examenRepository.findAll();
    }
}
