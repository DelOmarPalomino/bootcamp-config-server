package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.repository.DetalleConsultaRepository;
import com.bootcamp.databases.service.DetalleConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleConsultaServiceImpl implements DetalleConsultaService {

    @Autowired
    private DetalleConsultaRepository detalleConsultaRepository;

    @Override
    public DetalleConsulta registrar(DetalleConsulta detalle) throws Exception {
        return detalleConsultaRepository.save(detalle);
    }

    @Override
    public DetalleConsulta modificar(DetalleConsulta detalle) throws Exception {
        return detalleConsultaRepository.save(detalle);
    }

    @Override
    public void eliminar(String id) throws Exception {
        detalleConsultaRepository.deleteById(id);
    }

    @Override
    public DetalleConsulta listarPorId(String id) throws Exception {
        Optional<DetalleConsulta> detalle = detalleConsultaRepository.findById(id);
        return detalle.orElseThrow(() -> new Exception("El detalle de la consulta no existe."));
    }

    @Override
    public List<DetalleConsulta> listarTodos() throws Exception {
        return detalleConsultaRepository.findAll();
    }
}
