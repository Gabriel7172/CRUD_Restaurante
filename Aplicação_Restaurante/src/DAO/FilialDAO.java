package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.FilialDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class FilialDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FilialDTO> lista = new ArrayList<>();
    
    public void cadastrarFilial(FilialDTO objFilialDTO) {
        String sql = "INSERT INTO Filiais (Endereco, Email, Telefone, Quant_mesas, Avaliacao) VALUES (?,?,?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            pstm.setString(1, objFilialDTO.getEndereço_FiliaisDTO());
            pstm.setString(2, objFilialDTO.getEmail_FiliaisDTO());
            pstm.setString(3, objFilialDTO.getTelefone_FiliaisDTO());
            pstm.setInt(4, objFilialDTO.getQtndMesas_FiliaisDTO());
            pstm.setString(5, objFilialDTO.getAvaliação_FiliaisDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'FilialDAO': " + erro);
        }
    }
    
    public ArrayList<FilialDTO> listarFilial() {
        String sql = "SELECT * FROM Filiais";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                FilialDTO objFilialDTO = new FilialDTO();
                objFilialDTO.setEndereço_FiliaisDTO(rs.getString("Endereco"));
                objFilialDTO.setEmail_FiliaisDTO(rs.getString("Email"));
                objFilialDTO.setTelefone_FiliaisDTO(rs.getString("Telefone"));
                objFilialDTO.setQtndMesas_FiliaisDTO(rs.getInt("Quant_mesas"));
                objFilialDTO.setAvaliação_FiliaisDTO(rs.getString("Avaliacao"));
                
                lista.add(objFilialDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'FilialDAO' - 'listarFilial': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<FilialDTO> pesquisarFilial(String valor, String item) {
        String sql = "SELECT * FROM Filiais where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                FilialDTO objFilialDTO = new FilialDTO();
                objFilialDTO.setEndereço_FiliaisDTO(rs.getString("Endereco"));
                objFilialDTO.setEmail_FiliaisDTO(rs.getString("Email"));
                objFilialDTO.setTelefone_FiliaisDTO(rs.getString("Telefone"));
                objFilialDTO.setQtndMesas_FiliaisDTO(rs.getInt("Quant_mesas"));
                objFilialDTO.setAvaliação_FiliaisDTO(rs.getString("Avaliacao"));
                
                lista.add(objFilialDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'FilialDAO' - 'pesquisarFilial': " + erro);
        }
        
        return lista;
    }
}
