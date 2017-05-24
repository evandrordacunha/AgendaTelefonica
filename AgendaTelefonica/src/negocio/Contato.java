package negocio;

public class Contato {
	
	private String nome,telefone;
	 

	public Contato(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}
	@Override
	public String toString() {
		return "Nome: " +getNome() 
		+"\n"+"Telefone: "+getTelefone()+"\n";
	}
}
