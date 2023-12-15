package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @PostMapping("/nueva")
    public ResponseEntity<Especialidad> registrar(@RequestBody Especialidad especialidad) {
        try {
            Especialidad especialidadRegistrada = especialidadService.registrar(especialidad);
            return ResponseEntity.ok(especialidadRegistrada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Especialidad> actualizar(@RequestBody Especialidad especialidad) {
        try {
            Especialidad especialidadActualizada = especialidadService.modificar(especialidad);
            return ResponseEntity.ok(especialidadActualizada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        try {
            especialidadService.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Especialidad> listarPorId(@PathVariable("id") int id) {
        try {
            Especialidad especialidad = especialidadService.listarPorId(id);
            return ResponseEntity.ok(especialidad);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Especialidad>> listarTodos() {
        try {
            List<Especialidad> listaEspecialidades = especialidadService.listarTodos();
            return ResponseEntity.ok(listaEspecialidades);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
