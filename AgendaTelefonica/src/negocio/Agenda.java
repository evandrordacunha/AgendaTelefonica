package negocio;

import java.util.List;

public interface Agenda {
	
	void adicionarContato(Contato contato) throws CadastroException;
	void ordenarPorNome(List<Contato> contatos) throws CadastroException;
	List<Contato> getAgenda() throws CadastroException;
	String buscarTelefonePeloNome(String nome) throws CadastroException;
	List<String> listarNomesEmOrdemAlfabetica() throws CadastroException;
	List recuperarDados() throws CadastroException;
	void salvarDados() throws CadastroException;
}
