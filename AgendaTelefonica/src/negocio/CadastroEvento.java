package negocio;

public class CadastroEvento {
    private Contato contato;
    
    public CadastroEvento(Object fonte, Contato c) {
        super();
        contato = c;
    }
    
    public Contato getContato() {
        return contato;
    }
}
