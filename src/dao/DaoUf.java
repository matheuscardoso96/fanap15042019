/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import modelo.Uf;
import conexoes.Conectar;
import java.sql.SQLException;
import alertaj.Jop;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class DaoUf implements IDao {

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
         Uf uf = (Uf) obj;
         setQuery("INSERT INTO uf(codigo_ufed,codigo_pais_ufed, sigla_ufed, nome_ufed) VALUES(default,?,?,?)");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, uf.getCodigo_Pais());
            getPreparedStatement().setString(2, uf.getSigla());
            getPreparedStatement().setString(3, uf.getDescricao());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Inserido com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        
        return getMax("Select Max(codigo_ufed) from uf");

    }

    @Override
    public int getMax(String query) {
        setQuery(query);
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
         Uf uf = (Uf) obj;
         setQuery("UPDATE uf SET codigo_pais_ufed=?,sigla_ufed=?,nome_ufed=? WHERE codigo_ufed=?");
           try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, uf.getCodigo_Pais());
            getPreparedStatement().setString(2, uf.getSigla());
            getPreparedStatement().setString(3, uf.getDescricao());
            getPreparedStatement().setInt(4, uf.getCodigo());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Atualizado com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        uf = (Uf)selectCodigo(uf.getCodigo());
        return uf.getCodigo();

    }

    @Override
    public int delete(Object obj) {
         Uf uf = (Uf) obj;
         setQuery("DELETE FROM uf WHERE codigo_ufed=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, uf.getCodigo());
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
         Uf uf = new Uf();
        setQuery("SELECT * FROM uf WHERE codigo_ufed=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, i);
            setResultSet(getPreparedStatement().executeQuery());
            
            while(getResultSet().next())
            {
                uf.setCodigo(getResultSet().getInt("codigo_ufed"));
                uf.setCodigo_Pais(getResultSet().getInt("codigo_pais_ufed"));
                uf.setSigla(getResultSet().getString("sigla_ufed"));
                uf.setDescricao(getResultSet().getString("nome_ufed"));
                
                
            }
            conexao.fecharConexao();
            
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        return uf;
    }

    @Override
    public List select() {
        List list = new ArrayList();
        setQuery("SELECT * FROM uf ORDER BY codigo_ufed");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            setResultSet(getPreparedStatement().executeQuery());
            
            while(getResultSet().next())
            {
                list.add(new Uf(getResultSet().getInt("codigo_ufed"),getResultSet().getInt("codigo_pais_ufed"),getResultSet().getString("sigla_ufed"),getResultSet().getString("nome_ufed")));

                
            }
            conexao.fecharConexao();
            
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        return list;
    }

}
