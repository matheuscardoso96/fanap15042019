/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Endereco;
import dao.DaoEndereco;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class ControleEndereco {
    public int insert(Endereco endereco)
    {
        DaoEndereco edao = new DaoEndereco();
        return edao.insert(endereco);
    }
    
    public int update(Endereco endereco)
    {
        DaoEndereco edao = new DaoEndereco();
        return edao.update(endereco);
    }
    
        public int delete(Endereco endereco)
    {
        DaoEndereco edao = new DaoEndereco();
        return edao.delete(endereco);
    }
        
    public Object selectCodigo(int i)
    {
        DaoEndereco edao = new DaoEndereco();
        return edao.selectCodigo(i);
    
    }
    
    public Object selectCodigoCliente(int chaveEstrangeira, int codigoTendereco)
    {
        DaoEndereco edao = new DaoEndereco();
        return edao.selectCodigoCliente(chaveEstrangeira,codigoTendereco);
    
    }
    
    public List select()
    {
        DaoEndereco edao = new DaoEndereco();
        List enderecos = edao.select();
        return enderecos;
        
    }
    
        public List selectTipoEndereco(int chaveEstrangeira)
    {
        DaoEndereco edao = new DaoEndereco();
        List enderecos = edao.selectTipoEndereco(chaveEstrangeira);
        return enderecos;
        
    }
}
