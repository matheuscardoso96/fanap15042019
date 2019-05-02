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
import alertaj.Jop;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class DaoPais implements IDao {

    private Conectar conexao = new Conectar("localhost", "Fanap15042019", "root", "root");
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private String query;
    private int primaryKey;

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }



    @Override
    public int insert(Object obj) {
         Pais pais = (Pais) obj;
         setQuery("INSERT INTO pais(codigo_pais, nome_pais) VALUES(?,?)");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, pais.getCodigo());
            getPreparedStatement().setString(2, pais.getDescricao());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Inserido com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        pais = (Pais)selectCodigo(pais.getCodigo());
        return pais.getCodigo();

    }

    @Override
    public int getMax(String query) {
        setQuery("Select Max(codigo_pais) from pais");
        setPrimaryKey(0);
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            setResultSet(getPreparedStatement().executeQuery());
             if(resultSet != null && resultSet.next()){
                setPrimaryKey(resultSet.getInt(1));
            }
            conexao.fecharConexao();

        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        return primaryKey;
    }

    @Override
    public int update(Object obj) {
         Pais pais = (Pais) obj;
         setQuery("UPDATE pais SET nome_pais=? WHERE codigo_pais=?");
           try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(2, pais.getCodigo());
            getPreparedStatement().setString(1, pais.getDescricao());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Atualizado com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        pais = (Pais)selectCodigo(pais.getCodigo());
        return pais.getCodigo();

    }

    @Override
    public int delete(Object obj) {
        Pais pais = (Pais) obj;
         setQuery("DELETE FROM pais WHERE codigo_pais=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, pais.getCodigo());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Registro apagado!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        
        return 0;
    }

    @Override
    public Object selectCodigo(int i) {
        Pais pais = new Pais();
        setQuery("SELECT * FROM pais WHERE codigo_pais=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, i);
            setResultSet(getPreparedStatement().executeQuery());
            
            while(getResultSet().next())
            {
                pais.setCodigo(getResultSet().getInt("codigo_pais"));
                pais.setDescricao(getResultSet().getString("nome_pais"));
                
            }
            conexao.fecharConexao();
            
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        return pais;
    }

    @Override
    public List select() {
        List list = new ArrayList();
        setQuery("SELECT * FROM pais ORDER BY codigo_pais;");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            setResultSet(getPreparedStatement().executeQuery());
            
            while(getResultSet().next())
            {
                list.add(new Pais(getResultSet().getInt("codigo_pais"),getResultSet().getString("nome_pais")));

                
            }
            conexao.fecharConexao();
            
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        return list;
    }

}
