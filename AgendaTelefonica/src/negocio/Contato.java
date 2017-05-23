package negocio;

public class Contato {
	
	private String nome;
	private int telefone;

	public Contato(String nome, int telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Nome: " +getNome() 
		+"\n"+"Telefone: "+getTelefone()+"\n";
	}
}
