package com.bootcamp.databases.service;

import com.bootcamp.databases.model.Especialidad;

import java.util.List;

public interface EspecialidadService {

    Especialidad registrar(Especialidad especialidad) throws Exception;

    Especialidad modificar(Especialidad especialidad) throws Exception;

    void eliminar(int id) throws Exception;

    Especialidad listarPorId(int id) throws Exception;

    List<Especialidad> listarTodos() throws Exception;
}
