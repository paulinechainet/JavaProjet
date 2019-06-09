/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.sql.Connection;

/**
 *
 * @author grego
 * @param <T>
 */

public abstract class DAO<T> {

    /**
     *
     */
    protected Connection connect = null;
    
    /**
     *
     * @param conn
     */
    public DAO(Connection conn){
    this.connect = conn;
  }

    /**
     *
     */
    public DAO()
    {
        
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public abstract boolean create(T obj);

    /**
     *
     * @param obj
     * @return
     */
    public abstract boolean delete(T obj);

    /**
     *
     * @param obj
     * @return
     */
    public abstract boolean update(T obj);

    /**
     *
     * @return
     */
    public abstract int getMaxId();

    /**
     *
     * @param id
     * @return
     */
    public abstract T find(int id);
}
