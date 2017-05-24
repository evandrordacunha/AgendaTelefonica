package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import negocio.Contato;

public class ContatoTest {

	Contato c;

	@Before
	public void executa() {
		c = new Contato("Pedro", "51985858585");
	}

	@Test
	/**
	 * Chama o getNome() esperando receber o nome "Pedro"
	 */
	public void testGetNome() {
		assertEquals("Pedro", c.getNome());
	}

	@Test
	/**
	 * Chama o getTelefone() esperando receber o número de telefone: 51985858585
	 */
	public void testGetTelefone() {
		assertEquals("51985858585", c.getTelefone());
	}

}
