/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author T-Gamer
 */
public class Cliente {
    
    private int codigo;
    private int codigoTipoPessoa;
    private Date data;
    private String nomeRazaoSocial;
    private String sobrenomeNomeFantasia;
    private String rgIe;
    private String orgaoExpedidor;
    private String cpfCnpj;

    public Cliente() {
    }

    public Cliente(int codigo, int codigoTipoPessoa, Date data, String nomeRazaoSocial, String sobrenomeNomeFantasia, String rgIe, String orgaoExpedidor, String cpfCnpj) {
        this.codigo = codigo;
        this.codigoTipoPessoa = codigoTipoPessoa;
        this.data = data;
        this.nomeRazaoSocial = nomeRazaoSocial;
        this.sobrenomeNomeFantasia = sobrenomeNomeFantasia;
        this.rgIe = rgIe;
        this.orgaoExpedidor = orgaoExpedidor;
        this.cpfCnpj = cpfCnpj;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoTipoPessoa() {
        return codigoTipoPessoa;
    }

    public void setCodigoTipoPessoa(int codigoTipoPessoa) {
        this.codigoTipoPessoa = codigoTipoPessoa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public String getSobrenomeNomeFantasia() {
        return sobrenomeNomeFantasia;
    }

    public void setSobrenomeNomeFantasia(String sobrenomeNomeFantasia) {
        this.sobrenomeNomeFantasia = sobrenomeNomeFantasia;
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    @Override
    public String toString() {
        return nomeRazaoSocial;
    }
    
    
    
    
}
