package gui;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.CadastroException;
import negocio.Contato;
import negocio.Facade;

public class InterfaceListener {
	
	
	public Contato adicionarContato(JTextField tNome,JTextField tTelefone){
		Contato contato = new Contato(tNome.getText(),tTelefone.getText());
		return contato;
	}
	
	public void adicionarListagem(JTextArea textArea_1,Facade f) throws CadastroException{
			textArea_1.setText(f.getAgenda().toString());
	}

}
