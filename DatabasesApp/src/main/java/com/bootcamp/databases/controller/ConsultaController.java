package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@PostMapping("/nueva")
	public ResponseEntity<Consulta> registrar(@RequestBody Consulta consulta,
			@RequestBody List<DetalleConsulta> detallesConsulta) {
		try {
			Consulta consultaRegistrada = consultaService.registrar(consulta, detallesConsulta);
			return ResponseEntity.ok(consultaRegistrada);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<Consulta> actualizar(@RequestBody Consulta consulta) {
		try {
			Consulta consultaActualizada = consultaService.modificar(consulta);
			return consultaActualizada != null ? ResponseEntity.ok(consultaActualizada)
					: ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int id) {
		try {
			consultaService.eliminar(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable("id") int id) {
		try {
			Consulta consulta = consultaService.listarPorId(id);
			return consulta != null ? ResponseEntity.ok(consulta) : ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Consulta>> listarTodos() {
		try {
			List<Consulta> listaConsultas = consultaService.listarTodos();
			return ResponseEntity.ok(listaConsultas);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
