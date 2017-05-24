package Test;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import negocio.Agenda;
import negocio.Contato;

public class AgendaTest {

	Contato c1, c2, c3, c4, c5, c6, c7;
	Agenda a;

	@Before
	public void executa() {
		c1 = new Contato("Luis", "5135482365");
		c2 = new Contato("Melissa", "5198885563");
		c3 = new Contato("Kelly", "51998563252");
		c4 = new Contato("Adao", "5135488388");
		c5 = new Contato("Epaminondas", "5198881161");
		c6 = new Contato("Evandro", "51999999999");
		c7 = new Contato("Rafa", "51888888888");
		a = new Agenda();
		a.adicionar(c1);
	}

	@Test
	/**
	 * Adiciona um contato de nome Rafa na posição 1 da lista pois já temos 1
	 * contato cadastrado, e retorna true se foi adicionado normalmente
	 */
	public void testAdicionar() {
		a.adicionar(c7);
		assertTrue(a.getAgenda().get(1).getNome().equals(c7.getNome()));
	}

	@Test
	/**
	 * Insere contatos com nomes desordenados: Epaminondas, Melissa, Kelly,
	 * Adão. Chama o método ordenaPorNome() e testa se o primeiro nome da lista
	 * passou a ser Adão, pois em ordem alfabética, ele seria o primeiro.
	 */
	public void testOrdenaPorNome() {
		a.adicionar(c5);
		a.adicionar(c2);
		a.adicionar(c3);
		a.adicionar(c4);
		a.ordenaPorNome(a.getAgenda());
		assertTrue(a.getAgenda().get(0).getNome().equals(c4.getNome()));
	}

	@Test
	/**
	 * Buscar o telefone do contato C1 (Luis","5135482365"), armazena o
	 * resultado do método buscarTelefone que recebe o nome do contato C1 e
	 * verifica se o resultado obtido for o telefone de c1, então ele passa no
	 * teste.
	 */
	public void testBuscaPorNome() {
		String telefone = a.buscarTelefone(c1.getNome());
		assertTrue(telefone.equals(c1.getTelefone()));
	}

	@Test
	/**
	 * Verifica se a agenda não estiver vazia passa no teste, pois já inserimos
	 * contato nela e foram localizados esses contatos.
	 */
	public void testGetAgenda() {
		assertTrue(a.getAgenda().size() > 0);
	}

	@Test
	/**
	 * Adiciona contatos aleatoriamente, chama o método
	 * listarNomesEmOrdemAlfabetica e esperamos que o primeiro nome da lista
	 * após a ordenação seja o Adao, se for passa no teste.
	 */
	public void testListarNomesEmOrdemAlfabetica() {
		a.adicionar(c5);
		a.adicionar(c2);
		a.adicionar(c3);
		a.adicionar(c4);
		a.listarNomesEmOrdemAlfabetica();
		assertEquals("Adao", a.getAgenda().get(0).getNome());
	}
}
