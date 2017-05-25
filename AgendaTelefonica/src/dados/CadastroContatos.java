package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import negocio.Contato;

public class CadastroContatos {

	/**
	 * Atributos
	 */
	List<Contato> agenda;
	private static CadastroContatos ref;

	/**
	 * Construtor
	 */
	public CadastroContatos() {
		agenda = new ArrayList<Contato>();
	}

	public static CadastroContatos getInstance() {
		if (ref == null)
			ref = new CadastroContatos();
		return ref;
	}

	/**
	 * 
	 * @param c
	 */
	public void adicionar(Contato c) {
		agenda.add(c);
	}

	/**
	 * 
	 * @param contatos
	 */
	public static void ordenarPorNome(List<Contato> contatos) {
		Collections.sort(contatos, new Comparator<Contato>() {

			@Override
			public int compare(Contato c1, Contato c2) {
				return c1.getNome().compareTo(c2.getNome());
			}

		});
	}

	public int compare(Contato c1, Contato c2) {
		// TODO Auto-generated method stub
		return c1.getNome().compareTo(c2.getNome());
	}

	/**
	 * 
	 * @return agenda
	 */
	public List<Contato> getAgenda() {
		return agenda;
	}

	/**
	 * 
	 * @param nome
	 * @return telefone
	 */
	public String buscarTelefonePeloNome(String nome) {
		Contato c = null;
		for (int i = 0; i < agenda.size(); i++) {
			c = agenda.get(i);
			if (c.getNome().equalsIgnoreCase(nome)) {
				return c.getTelefone();
			}
		}
		return "Contato não encontrado!";
	}

	public List<String> listarNomesEmOrdemAlfabetica() {
		// cria uma lista temporaria copiando os contatos da agenda
		List<Contato> contatos = agenda;
		// ordena a lista temporária por nome
		ordenarPorNome(contatos);
		// cria a lista onde serão aramazenados somente os nome para retorno
		List<String> nomes = new ArrayList<>();
		Contato c = null;
		// percorre a lista já ordenada adicionando os nomes na lista de nome
		for (int i = 0; i < contatos.size(); i++) {
			c = agenda.get(i);
			nomes.add(c.getNome());
		}
		// retorna nomes já ordenados
		return nomes;
	}
}
