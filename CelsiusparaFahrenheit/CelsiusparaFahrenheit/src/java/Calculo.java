
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculo")
public class Calculo extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String escolha = request.getParameter("paleta");
            float valor = Float.parseFloat(request.getParameter("valor")) ;
            response.setContentType("text/html;charset=UTF-8");
                        
        if( "Celsius".equals(escolha)) 
        {
            float F = ((valor * 9) / 5) + 32;
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Calculo</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>O resultado foi:" + F + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } else{
            float C = ((valor - 32) * 5) / 9;
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Calculo</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>O resultado foi:" + C + "</h1>");
                out.println("</body>");
                out.println("</html>");
        }
        }

    }
}
    