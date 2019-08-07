package courseraforum.Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import courseraforum.dao.UsuarioDAO;
import courseraforum.dao.UsuarioDAOI;

@WebServlet("login")
public class LoginServlet extends HttpServlet {
       
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		if (sessao != null) {
			sessao.invalidate();
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAOI cd = new UsuarioDAO();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String submitType = request.getParameter("submit");
        String c = cd.autenticar(login, senha);
        if(submitType.equals("Login")&& c!=null && !c.isEmpty())
        {
            
        }else{
            request.setAttribute("mensagem", "Usuário não registrado clique em registro");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
