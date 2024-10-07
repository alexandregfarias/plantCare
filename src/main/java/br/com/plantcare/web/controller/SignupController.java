package br.com.plantcare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.plantcare.entity.Usuario;
import br.com.plantcare.service.UsuarioService;

@Controller
public class SignupController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/signup")
	public String showSignupPage() {
		return "signup";
	}

	@PostMapping("/signup")
	public String registerUser(@ModelAttribute Usuario usuario) {
		usuarioService.cadastrarUsuario(usuario);
		return "redirect:/home";
	}

}