package Test;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import negocio.Facade;
import negocio.CadastroException;
import negocio.Contato;

public class AgendaTest {

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
			a.adicionarContato(c1);
			a.adicionarContato(c5);
			a.adicionarContato(c2);
			a.adicionarContato(c3);
			a.adicionarContato(c4);
		} catch (CadastroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Adiciona um contato na agenda, e verifica através do método "contains" se o mesmo
	 * se encontra cadastrado.
	 * 
	 */
	
	@Test
	public void testAdicionar() throws CadastroException {
		a.adicionarContato(c7);
		assertTrue(a.getAgenda().contains(c7));
	}
 
	/**
	 * Insere contatos com nomes desordenados: Epaminondas, Melissa, Kelly,
	 * Adão. Chama o método ordenaPorNome() e testa se o primeiro nome da lista
	 * passou a ser Adão, pois em ordem alfabética, ele seria o primeiro.
	 */
	/*
	@Test
	public void testOrdenarPorNome() throws CadastroException {

		a.ordenarPorNome(a.getAgenda());
		//assertTrue(a.getAgenda().get(0).getNome().equals(c4.getNome()));
		
	}
*/
	/**
	 * Buscar o telefone do contato C1 (Luis","5135482365"), armazena o
	 * resultado do método buscarTelefone que recebe o nome do contato C1 e
	 * verifica se o resultado obtido for o telefone de c1, então ele passa no
	 * teste.
	 */
	@Test
	public void testBuscarTelefonePeloNome() throws CadastroException {
		String telefone = a.buscarTelefonePeloNome(c1.getNome());
		//assertTrue(telefone.equals(c1.getTelefone()));
		//System.out.println(a.buscarTelefonePeloNome(c1.getNome()));
		System.out.println(telefone);
		System.out.println(a.getAgenda().toString());
	}
	/**
	 * Verifica se a agenda não estiver vazia passa no teste, pois já inserimos
	 * contato nela e foram localizados esses contatos.
	 */
	 /*
	@Test
	public void testGetAgenda() throws CadastroException {
		assertTrue(a.getAgenda().size() > 0);
	}

	/**
	 * Adiciona contatos aleatoriamente, chama o método
	 * listarNomesEmOrdemAlfabetica e esperamos que o primeiro nome da lista
	 * após a ordenação seja o Adao, se for passa no teste.
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
	
	/**
	 * Testa se a agenda recebeu os dados lidos do txt (!= null) então passa no teste 
	 * @throws CadastroException
	 */
	/*
	@Test
	public void testRecuperarDados() throws CadastroException{
		assertTrue(a.recuperarDados() !=null);
	}
	 
	/**
	 * TEsta 
	 * @throws CadastroException
	 */
	/*
	@Test
	public void testSalvarDados() throws CadastroException{
		assertTrue(a.salvarDados() == true);
	}
	 */
}
