package com.bootcamp.databases.service;

import com.bootcamp.databases.model.ConsultaExamen;

import java.util.List;

public interface ConsultaExamenService {

    ConsultaExamen registrar(ConsultaExamen consultaExamen) throws Exception;

    ConsultaExamen modificar(ConsultaExamen consultaExamen) throws Exception;

    void eliminar(int id) throws Exception;

    ConsultaExamen listarPorId(int id) throws Exception;

    List<ConsultaExamen> listarTodos() throws Exception;
}
