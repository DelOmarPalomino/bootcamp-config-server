package com.bootcamp.databases.service;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.DetalleConsulta;

import java.util.List;

public interface ConsultaService {

	Consulta registrar(Consulta consulta, List<DetalleConsulta> detallesConsulta) throws Exception;

	Consulta modificar(Consulta consulta) throws Exception;

	void eliminar(int id) throws Exception;

	Consulta listarPorId(int id) throws Exception;

	List<Consulta> listarTodos() throws Exception;
}
