/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import modelo.TipoEndereco;
import conexoes.Conectar;
import java.sql.SQLException;
import fanapUtil.Jop;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class DaoTipoEndereco implements IDao {

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
         TipoEndereco tEndereco = (TipoEndereco) obj;
         setQuery("INSERT INTO tipoendereco(codigo_tend, descricao_tend) VALUES(default,?)");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setString(1, tEndereco.getDescricao());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Inserido com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        
        return getMax("Select Max(codigo_tend) from tipoendereco");

    }

    //Pega a chave primaria de maior valor
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
         TipoEndereco tEndereco = (TipoEndereco) obj;
         setQuery("UPDATE tipoendereco SET descricao_tend=? WHERE codigo_tend=?");
           try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(2, tEndereco.getCodigo());
            getPreparedStatement().setString(1, tEndereco.getDescricao());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Atualizado com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        tEndereco = (TipoEndereco)selectCodigo(tEndereco.getCodigo());
        return tEndereco.getCodigo();

    }

    @Override
    public int delete(Object obj) {
         TipoEndereco tEndereco = (TipoEndereco) obj;
         setQuery("DELETE FROM tipoendereco WHERE codigo_tend=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, tEndereco.getCodigo());
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
         TipoEndereco tEndereco = new TipoEndereco();
        setQuery("SELECT * FROM tipoendereco WHERE codigo_tend=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, i);
            setResultSet(getPreparedStatement().executeQuery());
            
            while(getResultSet().next())
            {
                tEndereco.setCodigo(getResultSet().getInt("codigo_tend"));
                tEndereco.setDescricao(getResultSet().getString("descricao_tend"));
                
            }
            conexao.fecharConexao();
            
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        return tEndereco;
    }

    @Override
    public List select() {
        List list = new ArrayList();
        setQuery("SELECT * FROM tipoendereco ORDER BY codigo_tend;");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            setResultSet(getPreparedStatement().executeQuery());
            
            while(getResultSet().next())
            {
                list.add(new TipoEndereco(getResultSet().getInt("codigo_tend"),getResultSet().getString("descricao_tend")));

                
            }
            conexao.fecharConexao();
            
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }
        
        return list;
    }

}
