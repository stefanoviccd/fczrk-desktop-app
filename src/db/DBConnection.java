package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection connection;
    private static DBConnection instance;

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fczrkdb", "root", "root");
            } catch (SQLException e) {
                throw e;
            }
        }
        return connection;
    }
    
    public void connect() throws SQLException {
        DBConnection.getInstance().getConnection();
    }
    
    public void disconnect() throws SQLException {
    	DBConnection.getInstance().getConnection().close();
    }
    
    public void commit() throws SQLException {
    	DBConnection.getInstance().getConnection().commit();
    }
    
    public void rollback() throws SQLException {
    	DBConnection.getInstance().getConnection().rollback();
    }
    
}