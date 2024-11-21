package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.EntregasDTO;    
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class EntregasDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<EntregasDTO> lista = new ArrayList<>();
    
    public void cadastrarEntregas(EntregasDTO objEntregasDTO) {
        String sql = "INSERT INTO Entregas (Endereco, ID_pedido, Data_entrega) VALUES (?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            pstm.setString(1, objEntregasDTO.getEndereço_EntregasDTO());
            pstm.setInt(2, objEntregasDTO.getIDPedido_EntregasDTO());
            pstm.setString(3, objEntregasDTO.getDataEntrega_EntregasDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'EntregasDAO': " + erro);
        }
    }
    
    public ArrayList<EntregasDTO> listarEntregas() {
        String sql = "SELECT * FROM Entregas";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                EntregasDTO objEntregasDTO = new EntregasDTO();
                objEntregasDTO.setEndereço_EntregasDTO(rs.getString("Endereco"));
                objEntregasDTO.setIDPedido_EntregasDTO(rs.getInt("ID_pedido"));
                objEntregasDTO.setDataEntrega_EntregasDTO(rs.getString("Data_entrega"));
                
                lista.add(objEntregasDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'EntregasDAO' - 'listarEntregas': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<EntregasDTO> pesquisarEntregas(String valor, String item) {
        String sql = "SELECT * FROM Entregas where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                EntregasDTO objEntregasDTO = new EntregasDTO();
                objEntregasDTO.setEndereço_EntregasDTO(rs.getString("Endereco"));
                objEntregasDTO.setIDPedido_EntregasDTO(rs.getInt("ID_pedido"));
                objEntregasDTO.setDataEntrega_EntregasDTO(rs.getString("Data_entrega"));
                
                lista.add(objEntregasDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'EntregasDAO' - 'pesquisarEntregas': " + erro);
        }
        
        return lista;
    }
}
