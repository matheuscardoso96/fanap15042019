package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author T-Gamer
 */
public class Conectar {
    
    private String url;
    private String nomeBanco;
    private String servidor;
    private String usuario;
    private String senha;
    private Connection conexao;

    public Conectar(String servidor, String nomeBanco, String usuario, String senha) {
        this.nomeBanco = nomeBanco;
        this.servidor = servidor;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Connection obterConexao()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setUrl("jdbc:mysql://" + getServidor() + "/" + getNomeBanco());
            setConexao((Connection) DriverManager.getConnection(getUrl(), getUsuario(), getSenha()));
            //JOptionPane.showMessageDialog(null, "Conexão aberta com sucesso!!!");
            
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {       
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            return conexao;
        }
        
    }
    
    
    public void fecharConexao()
    {
        try{
            getConexao().close();
            //JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!!!");
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    
    }
    
  /*  
    public static void main(String [] args)
    {
        Conectar conexao = new Conectar("localhost", "Fanap15042019", "root", "root");
        conexao.obterConexao();
    }
    
    */
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setgetNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
}
