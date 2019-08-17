/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Kasun
 */
public interface SuperRepository<T, ID> {

    public void setConnection(Connection connection) throws Exception;

    public boolean save(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(T t) throws Exception;

    public T findByNICNO(T t) throws Exception;

    public List<T> getAll() throws Exception;
}
