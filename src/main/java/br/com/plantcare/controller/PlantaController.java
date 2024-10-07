package br.com.plantcare.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plantcare.entity.Planta;
import br.com.plantcare.entity.Usuario;
import br.com.plantcare.service.PlantaService;
import br.com.plantcare.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuarios/{usuarioId}/plantas")
public class PlantaController {

	private final PlantaService plantaService;
	private final UsuarioService usuarioService;

	public PlantaController(PlantaService plantaService, UsuarioService usuarioService) {
		this.plantaService = plantaService;
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public ResponseEntity<Planta> cadastrarPlanta(@PathVariable Long usuarioId, @RequestBody Planta planta) {
		Optional<Usuario> usuario = usuarioService.obterUsuarioPorId(usuarioId);
		if (!usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		planta.setUsuario(usuario.get());
		Planta plantaCriada = plantaService.cadastrarPlanta(planta);
		return ResponseEntity.status(HttpStatus.CREATED).body(plantaCriada);
	}

	@GetMapping
	public ResponseEntity<List<Planta>> obterPlantas(@PathVariable Long usuarioId) {
		Optional<Usuario> usuario = usuarioService.obterUsuarioPorId(usuarioId);
		if (!usuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		List<Planta> plantas = plantaService.obterPlantasPorUsuario(usuario.get());
		return ResponseEntity.ok(plantas);
	}



}
