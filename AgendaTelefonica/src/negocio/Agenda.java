/**
O objetivo deste exercício é aplicar os padrões MVC, Presentation  Model, 
Oberserver, DAO/DTO quando apropriado.
Assim:
implemente uma agenda telefônica, que permite:
armazenar um nome e seu telefone;
recuperar um telefone, a partir do nome;
listar todos os nomes da agenda, em ordem alfabética;
recuperar os dados armazenados em um arquivo texto ao iniciar o programa;
salvar os dados da agenda ao encerrar o programa.
organize a aplicação usando os padrões citados, conforme apropriado. 
Use os exemplos fornecidos no moodle como orientação.

*/
package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda implements Comparator<Contato>{
	/**
	 * Atributos
	 */
	List<Contato> agenda;

	/**
	 * Construtor
	 */
	public Agenda() {
		agenda = new ArrayList<Contato>();
	}
	/**
	 * 
	 * @param c
	 */
	public void adicionar(Contato c){
		agenda.add(c);
	}

    /**
     * 
     * @param contatos
     */
	public static void ordenaPorNome(List<Contato> contatos) {
		Collections.sort(contatos, new Comparator<Contato>() {

			@Override
			public int compare(Contato c1, Contato c2)  {
				return c1.getNome().compareTo(c2.getNome());
			}
			
		});
	}

	@Override
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
	public String buscarTelefone(String nome){
		Contato c = null;
		for (int i = 0; i < agenda.size(); i++) {
			c = agenda.get(i);
			if(c.getNome().equalsIgnoreCase(nome)){
				return c.getTelefone();
			}
		}
		return "Contato não encontrado!";
	}
	public List<String> listarNomesEmOrdemAlfabetica(){
		//cria uma lista temporaria copiando os contatos da agenda
		List<Contato> contatos = agenda;
		//ordena a lista temporária por nome
		ordenaPorNome(contatos);
		//cria a lista onde serão aramazenados somente os nome para retorno
		List<String> nomes = new ArrayList<>();
		Contato c = null;
		//percorre a lista já ordenada adicionando os nomes na lista de nome
		for(int i=0; i <contatos.size();i++){
			c= agenda.get(i);
			nomes.add(c.getNome());
		}
		//retorna nomes já ordenados
		return nomes;
	}

 
	
}
