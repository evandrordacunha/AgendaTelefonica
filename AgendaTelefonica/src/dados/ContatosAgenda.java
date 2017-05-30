package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import negocio.Agenda;
import negocio.CadastroException;
import negocio.Contato;
import negocio.Validacao;

public class ContatosAgenda implements Agenda{

	/**
	 * Atributos
	 */
	List<Contato> agenda;
	private static ContatosAgenda ref;

	/**
	 * Construtor
	 */
	public ContatosAgenda() {
		agenda = new ArrayList<Contato>();
	}

	public static ContatosAgenda getInstance() {
		if (ref == null)
			ref = new ContatosAgenda();
		return ref;
	}
	/**
	 * 
	 * @param contatos
	 */
	@Override
	public void ordenarPorNome(List contatos) throws CadastroException {
		
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
	/**
	 * 
	 * @return agenda
	 */
	public List<Contato> getAgenda() {
		return agenda;
	}
	/**
	 * Recebe um nome epercorre a agenda tentando localizar o nome passado por parâmetro
	 * Se encontrar, traz o telefone.
	 */
	public String buscarTelefonePeloNome(String nome) throws CadastroException {
		String telefone = "";
		try {
			for (Contato c : agenda) {
				if (c.getNome().equalsIgnoreCase(nome))
					return c.getTelefone();
			}
			return "Contato não encontrado!";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Telefone não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			throw new CadastroException("Telefone não encontrado!", e);
		}
	}
	
	public List listarNomesEmOrdemAlfabetica() throws CadastroException {
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
	public boolean adicionarContato(Contato contato) throws CadastroException {
		 try {
			 if(Validacao.validaContato(contato)==true){
				 agenda.add(contato);

				 return true;
			 }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Contato não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			throw new CadastroException("Contato não encontrado!", e);
		
		}
		 return false;
	}
 

	@Override
	public List recuperarDados() throws CadastroException {
		List<String> contatosRecuperados = new ArrayList<>();
		try {
			//abre o arquivo
			FileReader fr = new FileReader("src/dados/Contatos.txt");
			BufferedReader br = new BufferedReader(fr);
			//A cada interação, é uma linha do arquivo e atribui-a a temp
			String linha = br.readLine();
			while (linha != null){
				//Aqui gera a sua "lista". No caso, imprime cada linha na tela.
				contatosRecuperados.add("\n"+linha);
				 linha = br.readLine(); // lê da segunda até a última linha
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
	public boolean salvarDados(Contato contato) throws CadastroException {
        boolean aux = false;
		try {
			FileWriter fw = new FileWriter("src/dados/Contatos.txt",true);
        	BufferedWriter buffWrite = new BufferedWriter(fw);
			buffWrite.write(contato.toString());
			 buffWrite.close();
			 aux = true;
			 return aux;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
    	return aux;
	}
}
