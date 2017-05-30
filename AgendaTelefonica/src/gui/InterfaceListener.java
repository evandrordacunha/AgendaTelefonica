package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.CadastroException;
import negocio.Contato;
import negocio.Facade;

public class InterfaceListener {
	
	
	public Contato adicionarContato(JTextField tNome,JTextField tTelefone,Facade f) throws CadastroException{
		Contato contato = new Contato(tNome.getText(),tTelefone.getText());
		f.salvarDados(contato);
		return contato;
	}
	
	public void atualizarListagem(JTextArea textArea_1,Facade f) throws CadastroException{
		List contatos = new ArrayList<>();
		contatos = f.recuperarDados();
		String dados = "";
		for(int i = 0 ; i < contatos.size();i++){
			dados = dados + contatos.get(i).toString();
		}
		textArea_1.setText(dados);
	}
	
	public void salvar(Contato contato,Facade f) throws CadastroException{
		f.salvarDados(contato);
	}
	
	public void buscarTelefonePeloNome(JTextField tNome,JTextArea textArea, Facade f){
		 try {
			textArea.setText(f.buscarTelefonePeloNome(tNome.getText()));
		} catch (CadastroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
