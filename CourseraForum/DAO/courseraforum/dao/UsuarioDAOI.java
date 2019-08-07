package courseraforum.dao;
import java.util.List;

import courseraforum.classemodel.Usuario;

public interface UsuarioDAOI {

	public void inserir(Usuario u);
	public Usuario recuperar(String login);
	public void adicionarPontos(String login, int pontos);
	public List<Usuario> ranking();
    public String autenticar(String login,String senha);
}
