package gui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import negocio.Contato;

public class InterfaceListagem {

	private JTextArea textArea_1;
	private List<Contato> listagem;
	
	public InterfaceListagem(List l,JTextArea t ) {
		super();
		listagem = l;
		textArea_1 = t;
		preencher();
		JScrollPane painelRolagem = new JScrollPane(textArea_1);
 
	}
	public InterfaceListagem(List l) {
		super();
		listagem = l;
		textArea_1 = new JTextArea();
		preencher();
		JScrollPane painelRolagem = new JScrollPane(textArea_1);
 
	}
	
	private void preencher() {
		for(Object o : listagem) {
			textArea_1.append(o.toString() + "\r\n");
		}
	}
}
