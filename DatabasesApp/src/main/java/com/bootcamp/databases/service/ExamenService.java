package com.bootcamp.databases.service;

import com.bootcamp.databases.model.Examen;

import java.util.List;

public interface ExamenService {

    Examen registrar(Examen examen) throws Exception;

    Examen modificar(Examen examen) throws Exception;

    void eliminar(int id) throws Exception;

    Examen listarPorId(int id) throws Exception;

    List<Examen> listarTodos() throws Exception;
}
