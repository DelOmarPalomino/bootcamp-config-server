package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.ConsultaExamen;
import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.service.ConsultaExamenService;
import com.bootcamp.databases.service.DetalleConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultaExamen")
public class ConsultaExamenController {

    @Autowired
    private ConsultaExamenService consultaExamenService;

    @PostMapping("/nuevo")
    public ResponseEntity<ConsultaExamen> registrar(@RequestBody ConsultaExamen consultaExamen) {
        try {
            ConsultaExamen consultaRegistrada = consultaExamenService.registrar(consultaExamen);
            return ResponseEntity.ok(consultaRegistrada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ConsultaExamen> actualizar(@RequestBody ConsultaExamen consultaExamen) {
        try {
            ConsultaExamen consultaActualizada = consultaExamenService.modificar(consultaExamen);
            return ResponseEntity.ok(consultaActualizada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        try {
            consultaExamenService.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ConsultaExamen> listarPorId(@PathVariable("id") int id) {
        try {
            ConsultaExamen consultaExamen = consultaExamenService.listarPorId(id);
            return ResponseEntity.ok(consultaExamen);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ConsultaExamen>> listarTodos() {
        try {
            List<ConsultaExamen> listaConsultaExamenes = consultaExamenService.listarTodos();
            return ResponseEntity.ok(listaConsultaExamenes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
