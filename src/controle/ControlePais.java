/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Pais;
import dao.DaoPais;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class ControlePais {
    public int insert(Pais pais)
    {
        DaoPais pdao = new DaoPais();
        return pdao.insert(pais);
    }
    
    public int update(Pais pais)
    {
        DaoPais pdao = new DaoPais();
        return pdao.update(pais);
    }
    
        public int delete(Pais pais)
    {
        DaoPais pdao = new DaoPais();
        return pdao.delete(pais);
    }
        
    public Object selectCodigo(int i)
    {
        DaoPais pdao = new DaoPais();
        return pdao.selectCodigo(i);
    
    }
    
    public List select()
    {
        DaoPais pdao = new DaoPais();
        List paises = pdao.select();
        return paises;
        
    }
}
