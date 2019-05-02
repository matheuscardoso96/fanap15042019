/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Uf;
import dao.DaoUf;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class ControleUf {
    public int insert(Uf uf)
    {
        DaoUf udao = new DaoUf();
        return udao.insert(uf);
    }
    
    public int update(Uf uf)
    {
        DaoUf udao = new DaoUf();
        return udao.update(uf);
    }
    
        public int delete(Uf uf)
    {
        DaoUf udao = new DaoUf();
        return udao.delete(uf);
    }
        
    public Object selectCodigo(int i)
    {
        DaoUf udao = new DaoUf();
        return udao.selectCodigo(i);
    
    }
    
    public List select()
    {
        DaoUf udao = new DaoUf();
        List ufs = udao.select();
        return ufs;
        
    }
}
