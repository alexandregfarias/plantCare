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

import br.com.plantcare.entity.Usuario;
import br.com.plantcare.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	@GetMapping
	public ResponseEntity<List<Usuario>> obterUsuarios() {
		List<Usuario> usuarios = usuarioService.obterUsuarios();
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioService.obterUsuarioPorId(id);
		return usuario.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioCriado = usuarioService.cadastrarUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
	}

}
