package negocio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

import dados.CadastroContatos;

public class AgendaFacade implements Agenda {
	
	/**
	 * Atributos
	 */
	List<Contato> agenda;
	Agenda a;
	private static AgendaFacade ref;

	/**
	 * Construtor
	 * @throws CadastroException 
	 */
	public AgendaFacade() throws CadastroException {
		try {
			a = (Agenda) CadastroContatos.getInstance();
		} catch (Exception e) {
			throw new CadastroException("Falha ao criar fachada!", e);
		}
	}

	@Override
	public void adicionarContato(Contato contato) throws CadastroException {
		 try {
			 if(Validacao.validaContato(contato)==true){
				 a.adicionarContato(contato);
			 }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Contato não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			throw new CadastroException("Contato não encontrado!", e);
		}
		
	}
 
	@Override
	public void ordenarPorNome(List<Contato> contatos) throws CadastroException {
		
		try {
			Collections.sort(contatos, new Comparator<Contato>() {
				@Override
				public int compare(Contato c1, Contato c2) {
					return c1.getNome().compareTo(c2.getNome());
				}
			});
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao ordenar por contatos por nome!", "Erro", JOptionPane.ERROR_MESSAGE);
			throw new CadastroException("Falha ao ordenar por contatos por nome!", e);
		}
	}

	public int compare(Contato c1, Contato c2) {
		// TODO Auto-generated method stub
		return c1.getNome().compareTo(c2.getNome());
	}
	
 
	@Override
	public List<Contato> getAgenda() throws CadastroException {
		return a.getAgenda();
	}

	@Override
	public String buscarTelefonePeloNome(String nome) throws CadastroException {
		 try {
				Contato c = null;
				for (int i = 0; i < agenda.size(); i++) {
					c = agenda.get(i);
					if (c.getNome().equalsIgnoreCase(nome)) {
						return c.getTelefone();
					}
				}
				return "Contato não encontrado!";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Telefone não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			throw new CadastroException("Telefone não encontrado!", e);
		}
	}

	@Override
	public List<String> listarNomesEmOrdemAlfabetica() throws CadastroException {
		try {
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
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao tentar listar nomes em ordem alfabética!", "Erro", JOptionPane.ERROR_MESSAGE);
			throw new CadastroException("Falha ao tentar listar nomes em ordem alfabética!", e);
		}
	}

	@Override
	public List recuperarDados() throws CadastroException { 
		ArrayList<String> contatosRecuperados = new ArrayList<>();
		try {
			//abre o arquivo
			FileReader fr = new FileReader("lista.txt");
			BufferedReader br = new BufferedReader(fr);
			String temp;
			//A cada interação, é uma linha do arquivo e atribui-a a temp
			String textoArquivo = "";
			while ((temp = br.readLine()) != null)
			{
				//Aqui gera a sua "lista". No caso, imprimi cada linha na tela.
				contatosRecuperados.add(temp);
			}
		}
		catch (FileNotFoundException el)
		{
			System.out.println("Arquivo não Encontrado!");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return contatosRecuperados;
	}
		


	@Override
	public void salvarDados() throws CadastroException {
		// TODO Auto-generated method stub
		
	}



	

}
