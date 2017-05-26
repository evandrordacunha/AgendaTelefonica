package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.CadastroException;
import negocio.Contato;
import negocio.Facade;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField tNome;
	private JTextField tTelefone;
	private JTextField tPesquisa;
	private static Facade ag;
	private static InterfaceListener listener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
					 ag = new Facade();
					 listener = new InterfaceListener();
					ag.recuperarDados();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 335, 224);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbNome.setForeground(SystemColor.text);
		lbNome.setBounds(10, 22, 46, 14);
		panel.add(lbNome);
		
		tNome = new JTextField();
		tNome.setBounds(10, 41, 263, 20);
		panel.add(tNome);
		tNome.setColumns(10);
		
		JLabel lbTelefone = new JLabel("Telefone:");
		lbTelefone.setForeground(SystemColor.text);
		lbTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTelefone.setBounds(10, 72, 87, 14);
		panel.add(lbTelefone);
		
		tTelefone = new JTextField();
		tTelefone.setBounds(10, 90, 263, 20);
		panel.add(tTelefone);
		tTelefone.setColumns(10);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionText);
		panel_1.setBounds(345, 0, 368, 504);
		contentPane.add(panel_1);
		panel_1.setLayout(null); 
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(70, 43, 253, 388);
		panel_1.add(textArea_1);
		
		JButton btAdicionar = new JButton("Adicionar");
		btAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try {
					Contato c = listener.adicionarContato(tNome, tTelefone);
					ag.adicionarContato(c);
					listener.adicionarListagem(textArea_1, ag);
				} catch (CadastroException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btAdicionar.setBounds(184, 121, 89, 23);
		panel.add(btAdicionar);
		

		
		JLabel lbLista = new JLabel("Contatos da Agenda:");
		lbLista.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbLista.setForeground(SystemColor.text);
		lbLista.setBounds(111, 11, 165, 31);
		panel_1.add(lbLista);
		
		JButton btListar = new JButton("Salvar contatos");
		btListar.setBounds(70, 442, 253, 22);
		panel_1.add(btListar);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(112, 128, 144));
		panel_2.setBounds(0, 235, 335, 269);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbPesquisa = new JLabel("Pesquisar por nome:");
		lbPesquisa.setBounds(10, 10, 157, 31);
		panel_2.add(lbPesquisa);
		lbPesquisa.setForeground(Color.WHITE);
		lbPesquisa.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tPesquisa = new JTextField();
		tPesquisa.setBounds(10, 41, 190, 20);
		panel_2.add(tPesquisa);
		tPesquisa.setColumns(10);
		
		JButton btPesquisar = new JButton("Pesquisar");
		btPesquisar.setBounds(210, 40, 79, 23);
		panel_2.add(btPesquisar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 72, 279, 136);
		panel_2.add(textArea);
	}
}
