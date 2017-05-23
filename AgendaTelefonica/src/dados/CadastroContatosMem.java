package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.Contato;

public class CadastroContatosMem {
	private List<Contato> contatos;

	public CadastroContatosMem() {
		contatos = new ArrayList<Contato>();
	}

	public boolean adicionar(Contato contato) {
		return contatos.add(contato);
	}

	public Contato getContatoPorNome(String n) {
		for (Contato c : contatos) {
			if (c.getNome().equalsIgnoreCase(n))
				return c;
		}
		return null;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

}
