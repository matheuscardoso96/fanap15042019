/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.TipoPessoa;
import dao.DaoTipoPessoa;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class ControleTipoPessoa {
    public int insert(TipoPessoa tPessoa)
    {
        DaoTipoPessoa tpdao = new DaoTipoPessoa();
        return tpdao.insert(tPessoa);
    }
    
    public int update(TipoPessoa tPessoa)
    {
      DaoTipoPessoa tpdao = new DaoTipoPessoa();
        return tpdao.update(tPessoa);
    }
    
        public int delete(TipoPessoa tPessoa)
    {
      DaoTipoPessoa tpdao = new DaoTipoPessoa();
        return tpdao.delete(tPessoa);
    }
        
    public Object selectCodigo(int i)
    {
      DaoTipoPessoa tpdao = new DaoTipoPessoa();
        return tpdao.selectCodigo(i);
    
    }
    
    public List select()
    {
      DaoTipoPessoa tpdao = new DaoTipoPessoa();
        List tpessoas = tpdao.select();
        return tpessoas;
        
    }
}
