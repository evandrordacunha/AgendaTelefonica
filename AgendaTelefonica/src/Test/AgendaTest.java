package Test;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import negocio.AgendaFacade;
import negocio.CadastroException;
import negocio.Contato;

public class AgendaTest {

	Contato c1, c2, c3, c4, c5, c6, c7;
	AgendaFacade a;

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
			a = new AgendaFacade();
			a.adicionarContato(c1);
		} catch (CadastroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Adiciona um contato de nome Rafa na posi��o 1 da lista pois j� temos 1
	 * contato cadastrado, e retorna true se foi adicionado normalmente
	 */
	 /*
	@Test
	public void testAdicionar() throws CadastroException {
		a.adicionarContato(c7);
		assertTrue(a.getAgenda().get(1).getNome().equals(c7.getNome()));
	}
 
	/**
	 * Insere contatos com nomes desordenados: Epaminondas, Melissa, Kelly,
	 * Ad�o. Chama o m�todo ordenaPorNome() e testa se o primeiro nome da lista
	 * passou a ser Ad�o, pois em ordem alfab�tica, ele seria o primeiro.
	 */
	/*
	@Test
	public void testOrdenarPorNome() throws CadastroException {
		a.adicionarContato(c5);
		a.adicionarContato(c2);
		a.adicionarContato(c3);
		a.adicionarContato(c4);
		a.ordenarPorNome(a.getAgenda());
		assertTrue(a.getAgenda().get(0).getNome().equals(c4.getNome()));
	}
*/
	/**
	 * Buscar o telefone do contato C1 (Luis","5135482365"), armazena o
	 * resultado do m�todo buscarTelefone que recebe o nome do contato C1 e
	 * verifica se o resultado obtido for o telefone de c1, ent�o ele passa no
	 * teste.
	 */
	/*
	@Test
	public void testBuscarTelefonePeloNome() throws CadastroException {
		String telefone = a.buscarTelefonePeloNome(c1.getNome());
		assertTrue(telefone.equals(c1.getTelefone()));
	}
*/
	/**
	 * Verifica se a agenda n�o estiver vazia passa no teste, pois j� inserimos
	 * contato nela e foram localizados esses contatos.
	 */
	/*
	@Test
	public void testGetAgenda() throws CadastroException {
		assertTrue(a.getAgenda().size() > 0);
	}
*/
	/**
	 * Adiciona contatos aleatoriamente, chama o m�todo
	 * listarNomesEmOrdemAlfabetica e esperamos que o primeiro nome da lista
	 * ap�s a ordena��o seja o Adao, se for passa no teste.
	 */
	/*
	@Test
	public void testListarNomesEmOrdemAlfabetica() throws CadastroException {
		a.adicionarContato(c5);
		a.adicionarContato(c2);
		a.adicionarContato(c3);
		a.adicionarContato(c4);
		a.listarNomesEmOrdemAlfabetica();
		assertEquals("Adao", a.getAgenda().get(0).getNome());
	}
	*/
	
	@Test
	public void testRecuperarDados() throws CadastroException{
		
		System.out.println(a.recuperarDados());
	}
	 
}
