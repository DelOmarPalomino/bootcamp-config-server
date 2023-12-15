package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @PostMapping("/nuevo")
    public ResponseEntity<Examen> registrar(@RequestBody Examen examen) {
        try {
            Examen examenRegistrado = examenService.registrar(examen);
            return ResponseEntity.ok(examenRegistrado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Examen> actualizar(@RequestBody Examen examen) {
        try {
            Examen examenActualizado = examenService.modificar(examen);
            return ResponseEntity.ok(examenActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
        try {
            examenService.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Examen> listarPorId(@PathVariable("id") int id) {
        try {
            Examen examen = examenService.listarPorId(id);
            return ResponseEntity.ok(examen);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Examen>> listarTodos() {
        try {
            List<Examen> listaExamenes = examenService.listarTodos();
            return ResponseEntity.ok(listaExamenes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
