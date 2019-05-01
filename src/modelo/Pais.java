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
public class Pais {
    private int Codigo;
    private String Descricao;

    public Pais() {
    }

    public Pais(int Codigo, String Descricao) {
        this.Codigo = Codigo;
        this.Descricao = Descricao;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    
    
    
}
