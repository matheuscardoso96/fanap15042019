/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import modelo.TipoPessoa;
import conexoes.Conectar;
import java.sql.SQLException;
import alertaj.Jop;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class DaoTipoPessoa implements IDao {

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
         TipoPessoa tPessoa = (TipoPessoa) obj;
         setQuery("INSERT INTO tipopessoa(codigo_tpes,descricao_tpes) VALUES(default,?)");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setString(1, tPessoa.getDescricao());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Inserido com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        
        return getMax("Select Max(codigo_tpes) from tipopessoa");

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
         TipoPessoa tPessoa = (TipoPessoa) obj;
         setQuery("UPDATE tipopessoa SET descricao_tpes=? WHERE codigo_tpes=?");
           try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(2, tPessoa.getCodigo());
            getPreparedStatement().setString(1, tPessoa.getDescricao());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Atualizado com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        tPessoa = (TipoPessoa)selectCodigo(tPessoa.getCodigo());
        return tPessoa.getCodigo();

    }

    @Override
    public int delete(Object obj) {
         TipoPessoa tPessoa = (TipoPessoa) obj;
         setQuery("DELETE FROM tipopessoa WHERE codigo_tpes=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, tPessoa.getCodigo());
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
         TipoPessoa tPessoa = new TipoPessoa();
        setQuery("SELECT * FROM tipopessoa WHERE codigo_tpes=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, i);
            setResultSet(getPreparedStatement().executeQuery());
            
            while(getResultSet().next())
            {
                tPessoa.setCodigo(getResultSet().getInt("codigo_tpes"));
                tPessoa.setDescricao(getResultSet().getString("descricao_tpes"));
                
            }
            conexao.fecharConexao();
            
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        return tPessoa;
    }

    @Override
    public List select() {
        List list = new ArrayList();
        setQuery("SELECT * FROM tipopessoa ORDER BY codigo_tpes;");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            setResultSet(getPreparedStatement().executeQuery());
            
            while(getResultSet().next())
            {
                list.add(new TipoPessoa(getResultSet().getInt("codigo_tpes"),getResultSet().getString("descricao_tpes")));

                
            }
            conexao.fecharConexao();
            
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        return list;
    }

}
