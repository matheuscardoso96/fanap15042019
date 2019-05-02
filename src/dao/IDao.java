/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author T-Gamer
 */
public interface IDao {
    public int insert(Object obj);
    public int update(Object obj);
    public int delete(Object obj);
    public int getMax(String query);
    public Object selectCodigo(int i);
    public List select();
}
