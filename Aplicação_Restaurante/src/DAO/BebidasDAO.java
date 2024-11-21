package DAO;

import java.sql.*;

import DTO.BebidasDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabriel Possato
 */
public class BebidasDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<BebidasDTO> lista = new ArrayList<>();
    
    public void cadastrarBebida(BebidasDTO objBebidasDTO) {
        String sql = "INSERT INTO Bebidas (Nome, Descricao, Valor) VALUES (?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            
            pstm.setString(1, objBebidasDTO.getNome_BebidasDTO());
            pstm.setString(2, objBebidasDTO.getDescrição_BebidasDTO());
            pstm.setString(3, objBebidasDTO.getValor_BebidasDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'BebidasDAO': " + erro);
        }
    }
    
    public ArrayList<BebidasDTO> listarBebidas() {
        String sql = "SELECT * FROM Bebidas";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                BebidasDTO objBebidasDTO = new BebidasDTO();
                objBebidasDTO.setNome_BebidasDTO(rs.getString("Nome"));
                objBebidasDTO.setDescrição_BebidasDTO(rs.getString("Descricao"));
                objBebidasDTO.setValor_BebidasDTO(rs.getString("Valor"));
                
                lista.add(objBebidasDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'BebidasDAO' - 'listarBebidas': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<BebidasDTO> pesquisarBebidas(String valor, String item) {
        String sql = "SELECT * FROM Bebidas where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                BebidasDTO objBebidasDTO = new BebidasDTO();
                objBebidasDTO.setNome_BebidasDTO(rs.getString("Nome"));
                objBebidasDTO.setDescrição_BebidasDTO(rs.getString("Descricao"));
                objBebidasDTO.setValor_BebidasDTO(rs.getString("Valor"));
                
                lista.add(objBebidasDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'BebidasDAO' - 'pesquisarBebidas': " + erro);
        }
        
        return lista;
    }
}
