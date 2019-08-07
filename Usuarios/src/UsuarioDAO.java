import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    
    static{

            try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
    }
    
    public static List<Usuario> todosUsuarios() throws SQLException{
        List<Usuario> todos = new ArrayList<>();
        
        String url = "jdbc:postgresql://localhost:5432/usuario";
        String username = "postgres";
        String password = "123a";

        
        try(Connection c = DriverManager.getConnection(url,username,password);){
            String sql = "select login, nome, email, senha from usuario";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                todos.add(u);
            }
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel executar o acesso",e);
        }
        
        return todos;
    }
    
    public static void inserirUsuario(Usuario u) {
        String url = "jdbc:postgresql://localhost:5432/usuario";
        String username = "postgres";
        String password = "123a";

        
        try(Connection c = DriverManager.getConnection(url,username,password);){
            String sql = "INSERT INTO public.usuario(login, nome, email,senha) VALUES (?,?,?,?)";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, u.getLogin());
            stm.setString(2, u.getNome());
            stm.setString(3, u.getEmail());
            stm.setString(4, u.getSenha());
            stm.executeUpdate();
           
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel executar o acesso",e);
        }
    }
    
}
