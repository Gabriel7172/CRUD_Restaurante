package DAO;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class ConexãoDAO {
    
    public Connection connectorDB(){
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/Restaurante";
            String user = "root";
            String passwd = "";
            
            conn = DriverManager.getConnection(url, user, passwd);
        }
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'ConexãoDAO': " + erro);
        }
        return conn;
    } 
}
