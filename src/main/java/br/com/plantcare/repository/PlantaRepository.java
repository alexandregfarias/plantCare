package br.com.plantcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.plantcare.entity.Planta;
import br.com.plantcare.entity.Usuario;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
	List<Planta> findByUsuario(Usuario usuario);
}