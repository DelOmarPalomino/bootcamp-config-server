package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.repository.EspecialidadRepository;
import com.bootcamp.databases.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad registrar(Especialidad especialidad) throws Exception {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad modificar(Especialidad especialidad) throws Exception {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public void eliminar(int id) throws Exception {
        especialidadRepository.deleteById(id);
    }

    @Override
    public Especialidad listarPorId(int id) throws Exception {
        Optional<Especialidad> especialidad = especialidadRepository.findById(id);
        return especialidad.orElseThrow(() -> new Exception("La especialidad no existe."));
    }

    @Override
    public List<Especialidad> listarTodos() throws Exception {
        return especialidadRepository.findAll();
    }
}
