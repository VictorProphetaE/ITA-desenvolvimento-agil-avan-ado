package courseraforum.Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import courseraforum.classemodel.Usuario;
import courseraforum.dao.UsuarioDAO;


@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroServlet() {
        super();
        new UsuarioDAO();
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        Usuario u = new Usuario();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        
        if(login.isEmpty())
        {
			request.setAttribute("info", "É necessário preencher alguns campos");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        }else 
	        u.setLogin(login);
	        u.setEmail(email);
	        u.setNome(nome);
	        u.setSenha(senha);
	        u.setPontos(0);
	        new UsuarioDAO().inserir(u);
	        request.setAttribute("mensagemsucesso", "Cadastro concluido !!");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
        }

}
