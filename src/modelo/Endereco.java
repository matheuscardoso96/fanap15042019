/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author T-Gamer
 */
public class Endereco {
    private int codigo;
    private int codigoCliente;
    private int codigoTipoEndereco;
    private int codigoUf;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String referencia;

    public Endereco() {
    }

    public Endereco(int codigo, int codigoCliente, int codigoTipoEndereco, int codigoUf, String logradouro, String numero, String complemento, String bairro, String cidade, String cep, String referencia) {
        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
        this.codigoTipoEndereco = codigoTipoEndereco;
        this.codigoUf = codigoUf;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.referencia = referencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoTipoEndereco() {
        return codigoTipoEndereco;
    }

    public void setCodigoTipoEndereco(int codigoTipoEndereco) {
        this.codigoTipoEndereco = codigoTipoEndereco;
    }

    public int getCodigoUf() {
        return codigoUf;
    }

    public void setCodigoUf(int codigoUf) {
        this.codigoUf = codigoUf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return referencia;
    }
    
    
}
