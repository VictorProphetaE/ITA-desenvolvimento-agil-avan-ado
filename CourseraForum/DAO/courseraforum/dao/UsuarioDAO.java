package courseraforum.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import courseraforum.classemodel.Usuario;


public class UsuarioDAO implements UsuarioDAOI{

	static{

        try {
		Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    
	}	
	
        @Override
        public void inserir(Usuario u) {
        	String url = "jdbc:postgresql://localhost:5432/coursera_usuario";
            String username = "postgres";
            String password = "123a";
	        try(Connection c = DriverManager.getConnection(url,username,password);){
	            String sql = "INSERT INTO usuario(\r\n" + 
	            		"	login, email, nome, senha, pontos)\r\n" + 
	            		"	VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement stm = c.prepareStatement(sql);
	            stm.setString(1, u.getLogin());
	            stm.setString(2, u.getEmail());
	            stm.setString(3, u.getNome());
	            stm.setString(4, u.getSenha());
	            stm.setInt(5, u.getPontos());
	            stm.executeUpdate();
	           
	        }catch(SQLException e){
	            throw new RuntimeException("Não foi possivel executar o acesso",e);
	        }
	}
	
        @Override
        public Usuario recuperar(String login) {
        	String url = "jdbc:postgresql://localhost:5432/coursera_usuario";
            String username = "postgres";
            String password = "123a";
        try(Connection c = DriverManager.getConnection(url,username,password);){
            String sql = "SELECT * FROM usuario WHERE login = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
            while(rs.next()) {
            	Usuario u = new Usuario();
            	u.setLogin(rs.getString("login"));
		u.setEmail(rs.getString("email"));
		u.setNome(rs.getString("nome"));
		u.setSenha(rs.getString("senha"));
		u.setPontos(rs.getInt("pontos"));            	
            	return u;
            }
           
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel executar o acesso",e);
        }
		return null;
	}
	
        @Override
        public void adicionarPontos(String login, int pontos) {
        	String url = "jdbc:postgresql://localhost:5432/coursera_usuario";
            String username = "postgres";
            String password = "123a";
        try(Connection c = DriverManager.getConnection(url,username,password);){
            String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, pontos);
            stm.setString(2, login);
            stm.executeUpdate();
           
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel executar o acesso",e);
        }
	}
	
        @Override
        public List<Usuario> ranking(){
        	String url = "jdbc:postgresql://localhost:5432/coursera_usuario";
            String username = "postgres";
            String password = "123a";
        List<Usuario> todos = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(url,username,password);){
            String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
		u.setEmail(rs.getString("email"));
		u.setNome(rs.getString("nome"));
		u.setSenha(rs.getString("senha"));
		u.setPontos(rs.getInt("pontos"));  
                todos.add(u);
            }
   
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel executar o acesso",e);
        }
        return todos;
	}
        
        @Override
        public String autenticar(String login,String senha){
        	String url = "jdbc:postgresql://localhost:5432/coursera_usuario";
            String username = "postgres";
            String password = "123a";
        try(Connection c = DriverManager.getConnection(url,username,password);){
            PreparedStatement ps = c.prepareStatement("SELECT nome FROM usuario WHERE login = ? AND senha ?");
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    return rs.getString("nome");
                }else{
                    throw new Exception("Não possivel autenticar usuario");
                }
        }   catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
        
}
