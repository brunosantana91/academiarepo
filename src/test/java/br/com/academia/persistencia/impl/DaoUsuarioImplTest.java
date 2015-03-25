package br.com.academia.persistencia.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.academia.entidades.Usuario;
import br.com.academia.entidades.util.Permissoes;
import br.com.academia.persistencia.DaoUsuario;

public class DaoUsuarioImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuscarPorId() {
		List<Permissoes> p1 = new ArrayList<Permissoes>();
		p1.add(Permissoes.INSTRUTOR);

		Usuario usuario1 = new Usuario();
		usuario1.setAtivo(true);
		usuario1.setLogin("login");
		usuario1.setPermissoes(p1);
		usuario1.setSenha("senha");
		
		DaoUsuario daoFalso = mock(DaoUsuarioImpl.class);
		when(daoFalso.buscarPorId(1)).thenReturn(usuario1);
		
		Usuario resultado = daoFalso.buscarPorId(1);
		
		assertEquals(resultado, usuario1);
	}

	@Test
	public void testListar() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditar() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemover() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarUsuarioPorLoginESenha() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarUsuarioPorLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarUsuarioPorPermissoes() {
		fail("Not yet implemented");
	}

}
