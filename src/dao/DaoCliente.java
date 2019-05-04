/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import modelo.Cliente;
import conexoes.Conectar;
import java.sql.SQLException;
import fanapUtil.Jop;
import dao.IDao;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author T-Gamer
 */
public class DaoCliente implements IDao {

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
        Cliente cliente = (Cliente) obj;
        setQuery("INSERT INTO cliente(codigo_clie, codigo_tpes_clie,nome_razaosocial_clie, sobrenome_nomefantasia_clie, rg_ie_clie, orgao_exp_clie, cpf_cnpj_clie) "
                + "VALUES(default,?,?,?,?,?,?)");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, cliente.getCodigoTipoPessoa());
            getPreparedStatement().setString(2, cliente.getNomeRazaoSocial());
            getPreparedStatement().setString(3, cliente.getSobrenomeNomeFantasia());
            getPreparedStatement().setString(4, cliente.getRgIe());
            getPreparedStatement().setString(5, cliente.getOrgaoExpedidor());
            getPreparedStatement().setString(6, cliente.getCpfCnpj());
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
        Cliente cliente = (Cliente) obj;
        setQuery("UPDATE cliente SET codigo_tpes_clie=?,nome_razaosocial_clie=?, "
                + "sobrenome_nomefantasia_clie=?, rg_ie_clie=?, orgao_exp_clie=?, cpf_cnpj_clie=? WHERE codigo_clie=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, cliente.getCodigoTipoPessoa());
            getPreparedStatement().setString(2, cliente.getNomeRazaoSocial());
            getPreparedStatement().setString(3, cliente.getSobrenomeNomeFantasia());
            getPreparedStatement().setString(4, cliente.getRgIe());
            getPreparedStatement().setString(5, cliente.getOrgaoExpedidor());
            getPreparedStatement().setString(6, cliente.getCpfCnpj());
            getPreparedStatement().setInt(7, cliente.getCodigo());
            getPreparedStatement().executeUpdate();
            conexao.fecharConexao();
            Jop.alerta("Atualizado com sucesso!");
        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        cliente = (Cliente) selectCodigo(cliente.getCodigo());
        return cliente.getCodigo();

    }

    @Override
    public int delete(Object obj) {
        Cliente cliente = (Cliente) obj;
        setQuery("DELETE FROM cliente WHERE codigo_clie=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, cliente.getCodigo());
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
        Cliente cliente = new Cliente();
        setQuery("SELECT * FROM cliente WHERE codigo_clie=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, i);
            setResultSet(getPreparedStatement().executeQuery());
            while (getResultSet().next()) {
                cliente.setCodigo(getResultSet().getInt("codigo_clie"));
                cliente.setCodigoTipoPessoa(getResultSet().getInt("codigo_tpes_clie"));
                cliente.setData(getResultSet().getDate("registro_clie"));
                cliente.setNomeRazaoSocial(getResultSet().getString("nome_razaosocial_clie"));
                cliente.setSobrenomeNomeFantasia(getResultSet().getString("sobrenome_nomefantasia_clie"));
                cliente.setRgIe(getResultSet().getString("rg_ie_clie"));
                cliente.setOrgaoExpedidor(getResultSet().getString("orgao_exp_clie"));
                cliente.setCpfCnpj(getResultSet().getString("cpf_cnpj_clie"));

            }
            conexao.fecharConexao();

        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        return cliente;
    }

    @Override
    public List select() {
        List list = new ArrayList();
        setQuery("SELECT * FROM cliente ORDER BY codigo_clie");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            setResultSet(getPreparedStatement().executeQuery());

            while (getResultSet().next()) {
                list.add(new Cliente(getResultSet().getInt("codigo_clie"),
                        getResultSet().getInt("codigo_tpes_clie"),
                        getResultSet().getDate("registro_clie"),
                        getResultSet().getString("nome_razaosocial_clie"),
                        getResultSet().getString("sobrenome_nomefantasia_clie"),
                        getResultSet().getString("rg_ie_clie"),
                        getResultSet().getString("orgao_exp_clie"),
                        getResultSet().getString("cpf_cnpj_clie")));

            }
            conexao.fecharConexao();

        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        return list;
    }
    
        public List selectFisicoouJuridico(int chaveEstrangeira) {
        List list = new ArrayList();
        setQuery("SELECT * FROM cliente WHERE codigo_tpes_clie=? ORDER BY codigo_clie");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setInt(1, chaveEstrangeira);
            setResultSet(getPreparedStatement().executeQuery());

            while (getResultSet().next()) {
                list.add(new Cliente(getResultSet().getInt("codigo_clie"),
                        getResultSet().getInt("codigo_tpes_clie"),
                        getResultSet().getDate("registro_clie"),
                        getResultSet().getString("nome_razaosocial_clie"),
                        getResultSet().getString("sobrenome_nomefantasia_clie"),
                        getResultSet().getString("rg_ie_clie"),
                        getResultSet().getString("orgao_exp_clie"),
                        getResultSet().getString("cpf_cnpj_clie")));

            }
            conexao.fecharConexao();

        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        return list;
    }

    public Object selectCpfCpnj(String cpf) {
        Cliente cliente = new Cliente();
        setQuery("SELECT * FROM cliente WHERE cpf_cnpj_clie=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setString(1, cpf);
            setResultSet(getPreparedStatement().executeQuery());

            while (getResultSet().next()) {
                cliente.setCodigo(getResultSet().getInt("codigo_clie"));
                cliente.setCodigoTipoPessoa(getResultSet().getInt("codigo_tpes_clie"));
                cliente.setData(getResultSet().getDate("registro_clie"));
                cliente.setNomeRazaoSocial(getResultSet().getString("nome_razaosocial_clie"));
                cliente.setSobrenomeNomeFantasia(getResultSet().getString("sobrenome_nomefantasia_clie"));
                cliente.setRgIe(getResultSet().getString("rg_ie_clie"));
                cliente.setOrgaoExpedidor(getResultSet().getString("orgao_exp_clie"));
                cliente.setCpfCnpj(getResultSet().getString("cpf_cnpj_clie"));

            }
            conexao.fecharConexao();

        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        return cliente;
    }
    
       public Object selectRgIe(String rgIe) {
        Cliente cliente = new Cliente();
        setQuery("SELECT * FROM cliente WHERE rg_ie_clie=?");
        try {
            conexao.obterConexao();
            setPreparedStatement((PreparedStatement) conexao.getConexao().prepareStatement(getQuery()));
            getPreparedStatement().setString(1, rgIe);
            setResultSet(getPreparedStatement().executeQuery());

            while (getResultSet().next()) {
                cliente.setCodigo(getResultSet().getInt("codigo_clie"));
                cliente.setCodigoTipoPessoa(getResultSet().getInt("codigo_tpes_clie"));
                cliente.setData(getResultSet().getDate("registro_clie"));
                cliente.setNomeRazaoSocial(getResultSet().getString("nome_razaosocial_clie"));
                cliente.setSobrenomeNomeFantasia(getResultSet().getString("sobrenome_nomefantasia_clie"));
                cliente.setRgIe(getResultSet().getString("rg_ie_clie"));
                cliente.setOrgaoExpedidor(getResultSet().getString("orgao_exp_clie"));
                cliente.setCpfCnpj(getResultSet().getString("cpf_cnpj_clie"));

            }
            conexao.fecharConexao();

        } catch (SQLException e) {
            Jop.alerta(e.getMessage());
        }

        return cliente;
    }

}
