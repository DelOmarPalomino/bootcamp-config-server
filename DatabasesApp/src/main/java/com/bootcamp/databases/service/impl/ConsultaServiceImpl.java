package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.repository.ConsultaRepository;
import com.bootcamp.databases.repository.DetalleConsultaRepository;
import com.bootcamp.databases.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private DetalleConsultaRepository detalleConsultaRepository;

	@Override
	public Consulta registrar(Consulta consulta, List<DetalleConsulta> detallesConsulta) throws Exception {
		List<DetalleConsulta> savedDetalles = detalleConsultaRepository.saveAll(detallesConsulta);
		List<String> detallesIds = savedDetalles.stream().map(DetalleConsulta::getId).collect(Collectors.toList());
		consulta.setDetallesConsultaIds(detallesIds);
		return consultaRepository.save(consulta);
	}

	@Override
	public Consulta modificar(Consulta consulta) throws Exception {
		return consultaRepository.save(consulta);
	}

	@Override
	public void eliminar(int id) throws Exception {
		consultaRepository.deleteById(id);
	}

	@Override
	public Consulta listarPorId(int id) throws Exception {
		Optional<Consulta> consulta = consultaRepository.findById(id);
		return consulta.orElseThrow(() -> new Exception("La consulta no existe."));
	}

	@Override
	public List<Consulta> listarTodos() throws Exception {
		return consultaRepository.findAll();
	}
}
