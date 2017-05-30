package negocio;

import java.util.List;
import java.util.Map;

public interface Agenda {
	
	boolean adicionarContato(Contato contato) throws CadastroException;
	void ordenarPorNome(List contatos) throws CadastroException;
	List getAgenda() throws CadastroException;
	String buscarTelefonePeloNome(String nome) throws CadastroException;
	List listarNomesEmOrdemAlfabetica() throws CadastroException;
	List recuperarDados() throws CadastroException;
	boolean salvarDados(Contato contatos) throws CadastroException;
}
