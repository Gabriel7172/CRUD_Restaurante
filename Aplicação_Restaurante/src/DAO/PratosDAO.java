package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.PratosDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class PratosDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PratosDTO> lista = new ArrayList<>();
    
    public void cadastrarPrato(PratosDTO objPratosDTO) {
        String sql = "INSERT INTO Pratos (Nome, Descricao, Valor) VALUES (?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            
            pstm.setString(1, objPratosDTO.getNome_PratosDTO());
            pstm.setString(2, objPratosDTO.getDescrição_PratosDTO());
            pstm.setString(3, objPratosDTO.getValor_PratosDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'PratosDAO': " + erro);
        }
    }
    
    public ArrayList<PratosDTO> listarPratos() {
        String sql = "SELECT * FROM Pratos";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                PratosDTO objPratosDTO = new PratosDTO();
                objPratosDTO.setNome_PratosDTO(rs.getString("Nome"));
                objPratosDTO.setDescrição_PratosDTO(rs.getString("Descricao"));
                objPratosDTO.setValor_PratosDTO(rs.getString("Valor"));
                
                lista.add(objPratosDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'PratosDAO' - 'listarPratos': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<PratosDTO> pesquisarPratos(String valor, String item) {
        String sql = "SELECT * FROM Pratos where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                PratosDTO objPratosDTO = new PratosDTO();
                objPratosDTO.setNome_PratosDTO(rs.getString("Nome"));
                objPratosDTO.setDescrição_PratosDTO(rs.getString("Descricao"));
                objPratosDTO.setValor_PratosDTO(rs.getString("Valor"));
                
                lista.add(objPratosDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'PratosDAO' - 'pesquisarPratos': " + erro);
        }
        
        return lista;
    }
}
