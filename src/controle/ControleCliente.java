/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Cliente;
import dao.DaoCliente;
import java.util.List;

/**
 *
 * @author T-Gamer
 */
public class ControleCliente {
    public int insert(Cliente cliente)
    {
        DaoCliente cdao = new DaoCliente();
        return cdao.insert(cliente);
    }
    
    public int update(Cliente cliente)
    {
        DaoCliente cdao = new DaoCliente();
        return cdao.update(cliente);
    }
    
        public int delete(Cliente cliente)
    {
        DaoCliente cdao = new DaoCliente();
        return cdao.delete(cliente);
    }
        
    public Object selectCodigo(int i)
    {
        DaoCliente cdao = new DaoCliente();
        return cdao.selectCodigo(i);
    
    }
    
    public List select()
    {
        DaoCliente cdao = new DaoCliente();
        List clientes = cdao.select();
        return clientes;
        
    }
    
        public List selectFisicoOuJuridico(int chaveEstrangeira)
    {
        DaoCliente cdao = new DaoCliente();
        List clientes = cdao.selectFisicoouJuridico(chaveEstrangeira);
        return clientes;
        
    }
    
    public Object selectCpfCpnj(String cpf)
    {
        DaoCliente cdao = new DaoCliente();
        return cdao.selectCpfCpnj(cpf);
    }
    
        public Object selectRgIe(String rgIe)
    {
        DaoCliente cdao = new DaoCliente();
        return cdao.selectRgIe(rgIe);
    }
}
