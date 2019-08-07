import java.sql.SQLException;
import java.util.List;

public class Principal {
    
    public static void main(String[] args) throws SQLException{
        List<Usuario> lista = UsuarioDAO.todosUsuarios();
        
        lista.forEach(System.out::println);
    }
    
}
