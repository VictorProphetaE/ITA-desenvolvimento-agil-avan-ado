package acessobancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    
    static{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
    
    public static List<Usuario> todosUsuarios() throws SQLException{
        List<Usuario> todos = new ArrayList<>();
        
        String url = "jdbc:derby://localhost:1527/usuario";
        String username = "admin1";
        String password = "admin1";

        
        try(Connection c = DriverManager.getConnection(url,username,password);){
            String sql = "select login, nome, email from usuario";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                todos.add(u);
            }
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel executar o acesso",e);
        }
        
        return todos;
    }
    
}
