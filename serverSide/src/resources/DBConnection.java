package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnection {
    private static DBConnection dbConnection=null;
    private static final int MAXIMUM_POOL_CONNECTIONS=10;
    private Connection connection;

    private ArrayList<Connection>idleConnections=new ArrayList<>();
    private ArrayList<Connection>usedConnections=new ArrayList<>();

    public DBConnection(){
        for (int i=0;i<MAXIMUM_POOL_CONNECTIONS;i++){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/dineMore","root",
                        "19980728");
                idleConnections.add(connection);
            } catch (SQLException|ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public static DBConnection getInstance(){
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }

    public synchronized Connection getConnection(){
        if (idleConnections.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        connection = idleConnections.get(0);
        usedConnections.add(connection);
        idleConnections.remove(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection){
        idleConnections.add(connection);
        usedConnections.remove(connection);
        notifyAll();
    }

    public synchronized void releaseAllConnections(){
        for (Connection usedConnection : usedConnections) {
            idleConnections.add(usedConnection);
        }
        usedConnections.removeAll(usedConnections);
        notifyAll();
    }

}
