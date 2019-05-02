/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.TipoEndereco;
import dao.DaoTipoEndereco;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class ControleTipoEndereco {
    public int insert(TipoEndereco tEndereco)
    {
        DaoTipoEndereco tedao = new DaoTipoEndereco();
        return tedao.insert(tEndereco);
    }
    
    public int update(TipoEndereco tEndereco)
    {
        DaoTipoEndereco tedao = new DaoTipoEndereco();
        return tedao.update(tEndereco);
    }
    
        public int delete(TipoEndereco tEndereco)
    {
        DaoTipoEndereco tedao = new DaoTipoEndereco();
        return tedao.delete(tEndereco);
    }
        
    public Object selectCodigo(int i)
    {
        DaoTipoEndereco tedao = new DaoTipoEndereco();
        return tedao.selectCodigo(i);
    
    }
    
    public List select()
    {
        DaoTipoEndereco tedao = new DaoTipoEndereco();
        List tenderecos = tedao.select();
        return tenderecos;
        
    }
}
