package ifma.dcomp.lbd.pedidovenda.repository;

import static org.hamcrest.CoreMatchers.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ifma.dcomp.lbd.pedidovenda.builer.UsuarioBuilder;
import ifma.dcomp.lbd.pedidovenda.model.Usuario;


public class UsuariosTest {

	private EntityManager manager;
	private static EntityManagerFactory emf;
	private Usuarios usuarios;

	@BeforeClass
	public static void inicio() {
		emf = Persistence.createEntityManagerFactory("pedidoVendaPUTest");
	}

	@Before
	public void antes() {
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		usuarios = new Usuarios(manager);
	}

	@After
	public void depois() {
		manager.getTransaction().commit();
	}

	@AfterClass
	public static void fim() {
		emf.close();
	}

	@Test
	public void deveEncontrarUsuarioPeloEmail() {

		final Usuario usuario = 
				UsuarioBuilder
				.umUsuario()
				.possuiEmail("joao@dasilva.com")
				.constroi();
		
		usuarios.salvaNovo(usuario );
		manager.flush();
		manager.clear();

		Usuario usuarioDoBanco = usuarios.porEmail("joao@dasilva.com");

		Assert.assertThat("joao@dasilva.com", is(equalTo(usuarioDoBanco.getEmail())) );
	}

	@Test(expected = NoResultException.class)
	public void naoDeveEncontrarUsuarioPeloNome() {
		
		Usuario usuarioDoBanco = usuarios.porNome("Pedro Jose");
	}

	
	@Test
	public void deveExcluirUmUsuario() {
		Usuario usuario = UsuarioBuilder.umUsuario().possuiEmail("joao@dasilva.com").constroi();

		usuarios.salvaNovo(usuario);
	
		usuarios.exclui(usuario);
		
		manager.flush();
		manager.clear();

		Usuario usuarioExcluido = usuarios.porEmail("joao@dasilva.com");
		Assert.assertNull(usuarioExcluido ); 

	}

	public void deveAlterarUmUsuario() {
		Usuario usuario = UsuarioBuilder.umUsuario().comNome("João Carlos").constroi();

		usuarios.salvaNovo(usuario);
		usuario.setNome("João da Silva");

		usuarios.atualiza(usuario);

		manager.flush();

		Usuario novoUsuario = usuarios.porNome("João da Silva" );
		Assert.assertNotNull(novoUsuario);
		
		Usuario usuarioInexistente = usuarios.porNome("João Carlos");
		
	}

}
