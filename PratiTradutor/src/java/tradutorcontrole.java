/*
Nome do Programa Tradutor
Nome: Victor Propheta Erbano
data: 19/07/19
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tradutorcontrole")
public class tradutorcontrole extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String escolha = request.getParameter("palavra");
        String traduzir = new Procurapalavra().recebePRT(escolha);
        request.setAttribute("traduzir",traduzir);
        request.getRequestDispatcher("Imprimir.jsp").forward(request,response);

    }
}