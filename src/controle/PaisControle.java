/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Pais;
import dao.PaisDao;

/**
 *
 * @author T-Gamer
 */
public class PaisControle {
    public void insert(Pais pais)
    {
        PaisDao pdao = new PaisDao();
        pdao.insert(pais);
    }
}
