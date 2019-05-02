/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alertaj;

import javax.swing.JOptionPane;

/**
 *
 * @author T-Gamer
 */
public class Jop {
    public static void alerta(String msg)
    {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static int alertaOpcao(String msg)
    {
       int input = JOptionPane.showConfirmDialog(null, msg);
       return input;
    }
}
