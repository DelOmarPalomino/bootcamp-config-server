package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.service.DetalleConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detallesConsulta")
public class DetalleConsultaController {

    @Autowired
    private DetalleConsultaService detalleConsultaService;

    @PostMapping("/nuevo")
    public ResponseEntity<DetalleConsulta> registrar(@RequestBody DetalleConsulta detalleConsulta) {
        try {
            DetalleConsulta detalleRegistrado = detalleConsultaService.registrar(detalleConsulta);
            return ResponseEntity.ok(detalleRegistrado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<DetalleConsulta> actualizar(@RequestBody DetalleConsulta detalleConsulta) {
        try {
            DetalleConsulta detalleActualizado = detalleConsultaService.modificar(detalleConsulta);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        try {
            detalleConsultaService.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DetalleConsulta> listarPorId(@PathVariable String id) {
        try {
            DetalleConsulta detalleConsulta = detalleConsultaService.listarPorId(id);
            return ResponseEntity.ok(detalleConsulta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DetalleConsulta>> listarTodos() {
        try {
            List<DetalleConsulta> listaDetallesConsulta = detalleConsultaService.listarTodos();
            return ResponseEntity.ok(listaDetallesConsulta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}