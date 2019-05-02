/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import modelo.Endereco;
import conexoes.Conectar;
import java.sql.SQLException;
import alertaj.Jop;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class DaoEndereco implements IDao {

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
        Endereco endereco = (Endereco) obj;
        setQuery("INSERT INTO clienteendereco(codigo_cend, codigo_clie_cend,codigo_tend_cend, "
                + "codigo_ufed_cend, logradouro_cend, numero_cend, complemento_cend, bairro_cend,"
                + "cidade_cend,cep_cend,referencia_cend)"
                + "VALUES(default,?,?,?,?,?,?,?,?,?,?)");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, endereco.getCodigoCliente());
            getPreparedStatement().setInt(2, endereco.getCodigoTipoEndereco());
            getPreparedStatement().setInt(3, endereco.getCodigoUf());
            getPreparedStatement().setString(4, endereco.getLogradouro());
            getPreparedStatement().setString(5, endereco.getNumero());
            getPreparedStatement().setString(6, endereco.getComplemento());
            getPreparedStatement().setString(7, endereco.getBairro());
            getPreparedStatement().setString(8, endereco.getCidade());
            getPreparedStatement().setString(9, endereco.getCep());
            getPreparedStatement().setString(10, endereco.getReferencia());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Inserido com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        return getMax("Select Max(codigo_clie) from Cliente");

    }

    @Override
    public int getMax(String query) {
        setQuery(query);
        setPrimaryKey(0);
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            setResultSet(getPreparedStatement().executeQuery());
            if (resultSet != null && resultSet.next()) {
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
        Endereco endereco = (Endereco) obj;
        setQuery("UPDATE clienteendereco SET codigo_clie_cend=?, codigo_tend_cend=?, "
                + "codigo_ufed_cend=?, logradouro_cend=?, numero_cend=?, "
                + "complemento_cend=?, bairro_cend=?, cidade_cend=?, cep_cend=?, referencia_cend=? WHERE codigo_cend=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, endereco.getCodigoCliente());
            getPreparedStatement().setInt(2, endereco.getCodigoTipoEndereco());
            getPreparedStatement().setInt(3, endereco.getCodigoUf());
            getPreparedStatement().setString(4, endereco.getLogradouro());
            getPreparedStatement().setString(5, endereco.getNumero());
            getPreparedStatement().setString(6, endereco.getComplemento());
            getPreparedStatement().setString(7, endereco.getBairro());
            getPreparedStatement().setString(8, endereco.getCidade());
            getPreparedStatement().setString(9, endereco.getCep());
            getPreparedStatement().setString(10, endereco.getReferencia());
            getPreparedStatement().setInt(11, endereco.getCodigo());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Atualizado com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        endereco = (Endereco) selectCodigo(endereco.getCodigo());
        return endereco.getCodigo();

    }

    @Override
    public int delete(Object obj) {
        Endereco endereco = (Endereco) obj;
        setQuery("DELETE FROM clienteendereco WHERE codigo_cend=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, endereco.getCodigo());
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
        Endereco endereco = new Endereco();
        setQuery("SELECT * FROM clienteendereco WHERE codigo_cend=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, i);
            setResultSet(getPreparedStatement().executeQuery());
            while (getResultSet().next()) {
                endereco.setCodigo(getResultSet().getInt("codigo_cend"));
                endereco.setCodigoCliente(getResultSet().getInt("codigo_clie_cend"));
                endereco.setCodigoTipoEndereco(getResultSet().getInt("codigo_tend_cend"));
                endereco.setCodigoUf(getResultSet().getInt("codigo_ufed_cend"));
                endereco.setLogradouro(getResultSet().getString("logradouro_cend"));
                endereco.setNumero(getResultSet().getString("numero_cend"));
                endereco.setComplemento(getResultSet().getString("complemento_cend"));
                endereco.setBairro(getResultSet().getString("bairro_cend"));
                endereco.setCidade(getResultSet().getString("cidade_cend"));
                endereco.setCep(getResultSet().getString("cep_cend"));
                endereco.setReferencia(getResultSet().getString("referencia_cend"));

            }
            conexao.fecharConexao();

        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        return endereco;
    }

    @Override
    public List select() {
        List list = new ArrayList();
        setQuery("SELECT * FROM clienteendereco ORDER BY codigo_cend");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            setResultSet(getPreparedStatement().executeQuery());

            while (getResultSet().next()) {
                list.add(new Endereco(getResultSet().getInt("codigo_cend"),
                        getResultSet().getInt("codigo_clie_cend"),
                        getResultSet().getInt("codigo_tend_cend"),
                        getResultSet().getInt("codigo_ufed_cend"),
                        getResultSet().getString("logradouro_cend"),
                        getResultSet().getString("numero_cend"),
                        getResultSet().getString("complemento_cend"),
                        getResultSet().getString("bairro_cend"),
                        getResultSet().getString("cidade_cend"),
                        getResultSet().getString("cep_cend"),
                        getResultSet().getString("referencia_cend")
                
                ));

            }
            conexao.fecharConexao();

        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        return list;
    }

}

