package gui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import negocio.Contato;

public class InterfaceListagem extends JFrame {

	private JTextArea textArea_1;
	private List<Contato> listagem;
	
	public InterfaceListagem(List l) {
		super("Listagem");
		listagem = l;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		textArea_1 = new JTextArea();
		preencher();
		JScrollPane painelRolagem = new JScrollPane(textArea_1);
		getContentPane().add(painelRolagem);
		setBounds(20, 20, 200, 100);
	}
	
	
	private void preencher() {
		for(Object o : listagem) {
			textArea_1.append(o + "\r\n");
		}
	}
}
