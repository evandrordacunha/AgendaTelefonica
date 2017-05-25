package negocio;

import java.awt.List;
import java.util.ArrayList;

public class Validacao {
	/**
	 * 
	 * @param contato
	 * @return True or False
	 */
	public static boolean validaContato(Contato contato) {
		if (contato.getNome() != "" && contato.getTelefone() != "") {
			return true;
		}
		return false;
	}
	
}
