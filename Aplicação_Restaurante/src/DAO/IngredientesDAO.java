package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.IngredientesDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class IngredientesDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<IngredientesDTO> lista = new ArrayList<>();
    
    public void cadastrarIngrediente(IngredientesDTO objIngredientesDTO) {
        String sql = "INSERT INTO Ingredientes (Nome, Unidade_Medida, ID_prato, ID_bebida) VALUES (?,?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            
            pstm.setString(1, objIngredientesDTO.getNome_IngredientesDTO());
            pstm.setString(2, objIngredientesDTO.getUnidadeMedida_IngredientesDTO());
            pstm.setInt(3, objIngredientesDTO.getIDPrato_IngredientesDTO());
            pstm.setInt(4, objIngredientesDTO.getIDBebida_IngredientesDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'IngredientesDAO': " + erro);
        }
    }
    
    public ArrayList<IngredientesDTO> listarIngredientes() {
        String sql = "SELECT * FROM Ingredientes";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                IngredientesDTO objIngredientesDTO = new IngredientesDTO();
                objIngredientesDTO.setNome_IngredientesDTO(rs.getString("Nome"));
                objIngredientesDTO.setUnidadeMedida_IngredientesDTO(rs.getString("Unidade_Medida"));
                objIngredientesDTO.setIDPrato_IngredientesDTO(rs.getInt("ID_prato"));
                objIngredientesDTO.setIDBebida_IngredientesDTO(rs.getInt("ID_bebida"));
                
                lista.add(objIngredientesDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'IngredientesDAO' - 'listarIngredientes': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<IngredientesDTO> pesquisarIngredientes(String valor, String item) {
        String sql = "SELECT * FROM Ingredientes where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                IngredientesDTO objIngredientesDTO = new IngredientesDTO();
                objIngredientesDTO.setNome_IngredientesDTO(rs.getString("Nome"));
                objIngredientesDTO.setUnidadeMedida_IngredientesDTO(rs.getString("Unidade_Medida"));
                objIngredientesDTO.setIDPrato_IngredientesDTO(rs.getInt("ID_prato"));
                objIngredientesDTO.setIDBebida_IngredientesDTO(rs.getInt("ID_bebida"));
                
                lista.add(objIngredientesDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'IngredientesDAO' - 'pesquisarIngredientes': " + erro);
        }
        
        return lista;
    }
}
