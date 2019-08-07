
public class PrincipalInsert {

	public static void main(String[] args) {

		Usuario u = new Usuario();
		u.setLogin("Victor");
		u.setNome("Victor Propheta");
		u.setEmail("vpropheta@zipmail.com");
		u.setSenha("14523");
		
		UsuarioDAO.inserirUsuario(u);

		Usuario v = new Usuario();
		v.setLogin("Joao");
		v.setNome("joao");
		v.setEmail("joao@email.com");
		v.setSenha("5457");

		
		UsuarioDAO.inserirUsuario(v);
		
	}

}
