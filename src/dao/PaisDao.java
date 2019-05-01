/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import modelo.Pais;
import conexoes.Conectar;
import java.sql.SQLException;
import JAlert.Jop;

/**
 *
 * @author T-Gamer
 */
public class PaisDao implements IDao {
    
    private Conectar conexao = new Conectar("localhost", "Fanap15042019", "root","root");

    @Override
    public void insert(Object obj) {
       Pais pais = (Pais) obj;
       String sql = "INSERT INTO pais(codigo_pais, nome_pais) VALUES(?,?)";
       try{
           conexao.obterConexao();
           PreparedStatement ps = (PreparedStatement) conexao.getConexao().prepareStatement(sql);
           ps.setInt(1, pais.getCodigo());
           ps.setString(2,pais.getDescricao());
           ps.executeUpdate();
           conexao.fecharConexao();
           Jop.alerta("Inserido com sucesso!");
       }catch(SQLException e)
       {
           Jop.alerta(e.getMessage());
       }
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object select(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
