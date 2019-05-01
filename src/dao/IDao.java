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
    public void insert(Object obj);
    public void update(Object obj);
    public void delete(Object obj);
    public Object select(int i);
    public List select();
}
