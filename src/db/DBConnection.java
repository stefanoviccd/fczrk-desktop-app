package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
            	  Properties properties = new Properties();
                  properties.load(new FileInputStream("configuration.properties"));
                  String url = properties.getProperty("url");
                  String user = properties.getProperty("username");
                  String password = properties.getProperty("password");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw e;
            } catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return connection;
    }
    
    public void connect() throws SQLException {
        getConnection();
    }
    
    public void disconnect() throws SQLException {
    	getConnection().close();
    }
    
    public void commit() throws SQLException {
    	getConnection().commit();
    }
    
    public void rollback() throws SQLException {
    	getConnection().rollback();
    }
    
}
