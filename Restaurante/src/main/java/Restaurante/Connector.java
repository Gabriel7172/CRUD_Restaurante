/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Connector{
    static String url = "jdbc:mysql://localhost:3306/Restaurante";
    static String user = "root";
    static String pwd = "1234";

    static Connection conn = null;

    public Connection getConnection(){
        try{
            if(conn == null){
                conn = DriverManager.getConnection(url, user, pwd);
                System.out.println("Conexao bem sucedida");
                return conn;
            }
            else{
                System.out.println("Conexao ja estabelecida");
                return conn;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
/*
public class Connector {
    static String url = "jdbc:mysql://localhost:3306/test";
    static String user = "root";
    static String pwd = "1234";
    
    static Connection conn = null;
    
    public Connector(){
        try {
                conn = DriverManager.getConnection(url, user, pwd);
                System.out.println("Conexão estabelecida com sucesso!");
                
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        

    }
    public static void criar(){
        try{
            String set = "insert into test (name) values (?, ?, ?, ?, ?, ?, ?);";
            //Statement statement = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement(set);
            //statement.executeUpdate("insert into test (name) values (?, ?, ?, ?, ?, ?, ?);");
            stmt.execute();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void fecharConn(){
        if (conn != null) {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
};
/*
test it later

package Restaurante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static Connection connection = null;

    // Static block to initialize the connection
    static {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String passwd = "1234";
            
            // Establish the connection
            connection = DriverManager.getConnection(url, user, passwd);
            System.out.println("Conexão estabelecida com sucesso!");
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Additional error handling, like logging or rethrowing as a RuntimeException, could be added here
        } 
        catch (SQLException e) {
            e.printStackTrace();
            // Additional error handling, like logging or rethrowing as a RuntimeException, could be added here
        }
    }

    // Method to get the connection
    public static Connection getConnection() {
        return connection;
    }

    // Method to close the connection (if needed)
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

*/