
package negocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import dados.ContatosAgenda;

public class Facade implements Agenda {

	/**
	 * Atributos
	 */
	List<Contato> agenda;
	ContatosAgenda a;
	private static Facade ref;

	/**
	 * Construtor
	 * 
	 * @throws CadastroException
	 */
	public Facade() throws CadastroException {
		try {
			a = ContatosAgenda.getInstance();
		} catch (Exception e) {
			throw new CadastroException("Falha ao criar fachada!", e);
		}
	}

	@Override
	public boolean adicionarContato(Contato contato) throws CadastroException {
		try {
			a.adicionarContato(contato);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
	return false;
	}

	@Override
	public void ordenarPorNome(List contatos) throws CadastroException {
		a.ordenarPorNome(contatos);
	}

	@Override
	public List<Contato> getAgenda() throws CadastroException {
		return a.getAgenda();
	}

	@Override
	public String buscarTelefonePeloNome(String nome) throws CadastroException {
		return a.buscarTelefonePeloNome(nome);
	}

	@Override
	public List listarNomesEmOrdemAlfabetica() throws CadastroException {
		return a.listarNomesEmOrdemAlfabetica();
	}

	@Override
	public List recuperarDados() throws CadastroException {
		return a.recuperarDados();
	}

	@Override
	public boolean salvarDados(Contato contato) throws CadastroException {
		return a.salvarDados(contato);
	}
}
