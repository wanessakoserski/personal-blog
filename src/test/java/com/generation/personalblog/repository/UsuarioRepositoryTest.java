package com.generation.personalblog.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.personalblog.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.save(new Usuario(0L, "Sky Children", "sky@gmail.com", "sky1234"));
		usuarioRepository.save(new Usuario(0L, "Marcelo Santos", "marcelo@gmail.com", "marcelo1234"));
		usuarioRepository.save(new Usuario(0L, "Daniel dos Santos", "daniel@gmail.com", "daniel1234"));
		usuarioRepository.save(new Usuario(0L, "Bruno dos Santos", "bruno@gmail.com", "sky1234"));
		
	}
	
	@Test
	@DisplayName("Retornar 1 usuario")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByEmail("sky@gmail.com");
		assertTrue(usuario.get().getEmail().equals("sky@gmail.com"));
	}
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Santos");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Marcelo Santos"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Daniel dos Santos"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Bruno dos Santos"));
	}
	
}
