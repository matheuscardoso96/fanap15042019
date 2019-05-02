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
}
