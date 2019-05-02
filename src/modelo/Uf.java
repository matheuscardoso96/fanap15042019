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
public class Uf {
    private int codigo;
    private int codigo_Pais;
    private String descricao;
    private String sigla;

    public Uf() {
    }

    public Uf(int codigo, int codigo_Pais,String sigla, String descricao) {
        this.codigo = codigo;
        this.codigo_Pais = codigo_Pais;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public int getCodigo_Pais() {
        return codigo_Pais;
    }

    public void setCodigo_Pais(int codigo_Pais) {
        this.codigo_Pais = codigo_Pais;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    @Override
    public String toString()
    {
        return descricao;
    }
    
    
    
    
}
