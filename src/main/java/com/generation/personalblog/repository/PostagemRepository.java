package com.generation.personalblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.personalblog.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
	public List<Postagem> findAllByTextoContainingIgnoreCase (String texto);
	
}
