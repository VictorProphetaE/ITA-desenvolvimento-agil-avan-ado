
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Autenticador a = new Autenticador();
        
        try {
            String nomeUsuario = a.autenticar(login, senha);
            request.setAttribute("nome",nomeUsuario);
            request.getRequestDispatcher("sucesso.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("erro",ex.getMessage());
            request.getRequestDispatcher("falha.jsp").forward(request, response);
        }
        
    }
}
