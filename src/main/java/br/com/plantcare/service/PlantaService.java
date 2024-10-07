package br.com.plantcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.plantcare.entity.Planta;
import br.com.plantcare.entity.Usuario;
import br.com.plantcare.repository.PlantaRepository;

@Service
public class PlantaService {

	private final PlantaRepository plantaRepository;

	public PlantaService(PlantaRepository plantaRepository) {
		this.plantaRepository = plantaRepository;
	}

	public Planta cadastrarPlanta(Planta planta) {
		return plantaRepository.save(planta);
	}

	public List<Planta> obterPlantas() {
		return plantaRepository.findAll();
	}

	public Optional<Planta> obterPlantaPorId(Long id) {
		return plantaRepository.findById(id);
	}

	public Planta atualizarPlanta(Planta planta) {
		return plantaRepository.save(planta);
	}

	public void deletarPlanta(Long id) {
		plantaRepository.deleteById(id);
	}

	public List<Planta> obterPlantasPorUsuario(Usuario usuario) {
		return plantaRepository.findByUsuario(usuario);
	}

}
