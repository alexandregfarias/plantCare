package br.com.plantcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.plantcare.entity.Usuario;
import br.com.plantcare.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> obterUsuarios() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> obterUsuarioPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario cadastrarUsuario(@Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
}
