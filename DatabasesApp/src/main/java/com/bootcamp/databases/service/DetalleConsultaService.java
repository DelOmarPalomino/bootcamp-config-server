package com.bootcamp.databases.service;

import com.bootcamp.databases.model.DetalleConsulta;

import java.util.List;

public interface DetalleConsultaService {

    DetalleConsulta registrar(DetalleConsulta detalle) throws Exception;

    DetalleConsulta modificar(DetalleConsulta detalle) throws Exception;

    void eliminar(String id) throws Exception;

    DetalleConsulta listarPorId(String id) throws Exception;

    List<DetalleConsulta> listarTodos() throws Exception;
}
