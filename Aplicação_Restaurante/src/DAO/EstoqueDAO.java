package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.EstoqueDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class EstoqueDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<EstoqueDTO> lista = new ArrayList<>();
    
    public void cadastrarEstoque(EstoqueDTO objEstoqueDTO) {
        String sql = "INSERT INTO Estoque (ID_fornecedor, Quantidade, ID_filial) VALUES (?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            pstm.setInt(1, objEstoqueDTO.getIDFornecedor_EstoqueDTO());
            pstm.setInt(2, objEstoqueDTO.getQntd_EstoqueDTO());
            pstm.setInt(3, objEstoqueDTO.getIDFilial_EstoqueDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'EstoqueDAO': " + erro);
        }
    }
    
    public ArrayList<EstoqueDTO> listarEstoque() {
        String sql = "SELECT * FROM Estoque";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                EstoqueDTO objEstoqueDTO = new EstoqueDTO();
                objEstoqueDTO.setIDFornecedor_EstoqueDTO(rs.getInt("ID_fornecedor"));
                objEstoqueDTO.setQntd_EstoqueDTO(rs.getInt("Quantidade"));
                objEstoqueDTO.setIDFilial_EstoqueDTO(rs.getInt("ID_filial"));
                
                lista.add(objEstoqueDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'EstoqueDAO' - 'listarEstoque': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<EstoqueDTO> pesquisarEstoque(String valor, String item) {
        String sql = "SELECT * FROM Estoque where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                EstoqueDTO objEstoqueDTO = new EstoqueDTO();
                objEstoqueDTO.setIDFornecedor_EstoqueDTO(rs.getInt("ID_fornecedor"));
                objEstoqueDTO.setQntd_EstoqueDTO(rs.getInt("Quantidade"));
                objEstoqueDTO.setIDFilial_EstoqueDTO(rs.getInt("ID_filial"));
                
                lista.add(objEstoqueDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'EstoqueDAO' - 'pesquisarEstoque': " + erro);
        }
        
        return lista;
    }
}
