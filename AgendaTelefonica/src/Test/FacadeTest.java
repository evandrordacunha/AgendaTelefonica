package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import negocio.CadastroException;
import negocio.Contato;
import negocio.Facade;

public class FacadeTest {
	Contato c1, c2, c3, c4, c5, c6, c7;
	Facade a;

	@Before
	public void executa() {
		c1 = new Contato("Luis", "5135482365");
		c2 = new Contato("Melissa", "5198885563");
		c3 = new Contato("Kelly", "51998563252");
		c4 = new Contato("Adao", "5135488388");
		c5 = new Contato("Epaminondas", "5198881161");
		c6 = new Contato("Evandro", "51999999999");
		c7 = new Contato("Rafa", "51888888888");
		try {
			a = new Facade();
	
		} catch (CadastroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testAdicionarContato() throws CadastroException {
		a.adicionarContato(c7);
		a.adicionarContato(c4);
		a.adicionarContato(c5);
		assertTrue(a.getAgenda().contains(c7));
	}

	/**
	 * 
	 * @throws CadastroException
	 */
	@Test
	public void testOrdenarPorNome() throws CadastroException {
			a.adicionarContato(c4);
			a.ordenarPorNome(a.getAgenda());
			assertEquals("Adao",a.getAgenda().get(0).getNome());
	}

	/**
	 * Usa o getAgenda para retornar a lista e o add(c1) para adicionar o contato C1 nela,
	 * se retornar true ao adicionar, então passa no teste.
	 * @throws CadastroException
	 */
	@Test
	public void testGetAgenda() throws CadastroException {
		assertTrue(a.getAgenda().add(c1) == true);
	}
	/**
	 * Espera receber o número do contato Luis, passando por parâmetro seu nome,
	 * se receber o número esperado informado, então passa no teste.
	 * @throws CadastroException
	 */
	@Test
	public void testBuscarTelefonePeloNome() throws CadastroException {
		assertEquals("5135482365", a.buscarTelefonePeloNome("Luis"));
	}

	/**
	 * 
	 * @throws CadastroException
	 */
	@Test
	public void testListarNomesEmOrdemAlfabetica() throws CadastroException {
		a.listarNomesEmOrdemAlfabetica();
		assertTrue(a.getAgenda().get(0).getNome().equals("Adao"));
	}
	
	/**
	 * Como já temos alguns nomes salvos no txt, testamos se o método recuperDados()
	 * carrega esses nomes para a agenda corretamente, caso retorne NULL, então não passa
	 * no teste.
	 * @throws CadastroException
	 */
	@Test
	public void testRecuperarDados() throws CadastroException {
		assertTrue(a.recuperarDados() != null);
	}
	
	@Test
	public void testSalvarDados() throws CadastroException {
		 
		assertTrue(a.salvarDados("Maradona","51985858585") == true);
	}
	

}
