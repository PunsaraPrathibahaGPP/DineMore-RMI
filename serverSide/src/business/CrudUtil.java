package business;

import resources.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CrudUtil{
//    private static Connection connection=null;
    public static PreparedStatement getPreparedStatement(String sql,Object... params)throws  Exception{
        System.out.println("getPreparedStatement Called...");
        Connection connection=DBConnection.getInstance().getConnection();
        System.out.println("getting PreparedStatement preparedStatement = connection.prepareStatement(sql)...");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("going to loop");
        for(int i=0;i<params.length;i++){
            preparedStatement.setObject(i+1,params);
            System.out.println("looping...");
        }
        System.out.println("getPreparedStatement Returning...");
        return preparedStatement;
    }

    public static ResultSet executeQuery(String sql,Object... params)throws  Exception{
        System.out.println("Execute Query Called...");
        return  getPreparedStatement(sql, params).executeQuery();
    }

    public static boolean executeUpdate(String sql,Object... params)throws Exception{
        System.out.println("Execute Update Called...");
        return getPreparedStatement(sql,params).executeUpdate()>0;
    }
}