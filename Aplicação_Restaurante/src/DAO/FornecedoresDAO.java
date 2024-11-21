package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.FornecedoresDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class FornecedoresDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FornecedoresDTO> lista = new ArrayList<>();
    
    public void cadastrarFornecedor(FornecedoresDTO objFornecedoresDTO) {
        String sql = "INSERT INTO Fornecedores (Nome, CNPJ, Tipo_material, Email, Telefone, Valor_material) VALUES (?,?,?,?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            pstm.setString(1, objFornecedoresDTO.getNome_FornecedoresDTO());
            pstm.setString(2, objFornecedoresDTO.getCNPJ_FornecedoresDTO());
            pstm.setString(3, objFornecedoresDTO.getMaterial_FornecedoresDTO());
            pstm.setString(4, objFornecedoresDTO.getEmail_FornecedoresDTO());
            pstm.setString(5, objFornecedoresDTO.getTelefone_FornecedoresDTO());
            pstm.setString(6, objFornecedoresDTO.getValor_FornecedoresDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'FornecedoresDAO': " + erro);
        }
    }
    
    public ArrayList<FornecedoresDTO> listarFornecedores() {
        String sql = "SELECT * FROM Fornecedores";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                FornecedoresDTO objFornecedoresDTO = new FornecedoresDTO();
                objFornecedoresDTO.setNome_FornecedoresDTO(rs.getString("Nome"));
                objFornecedoresDTO.setCNPJ_FornecedoresDTO(rs.getString("CNPJ"));
                objFornecedoresDTO.setMaterial_FornecedoresDTO(rs.getString("Tipo_material"));
                objFornecedoresDTO.setEmail_FornecedoresDTO(rs.getString("Email"));
                objFornecedoresDTO.setTelefone_FornecedoresDTO(rs.getString("Telefone"));
                objFornecedoresDTO.setValor_FornecedoresDTO(rs.getString("Valor_material"));
                
                lista.add(objFornecedoresDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'FornecedoresDAO' - 'listarFornecedores': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<FornecedoresDTO> pesquisarFornecedores(String valor, String item) {
        String sql = "SELECT * FROM Fornecedores where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                FornecedoresDTO objFornecedoresDTO = new FornecedoresDTO();
                objFornecedoresDTO.setNome_FornecedoresDTO(rs.getString("Nome"));
                objFornecedoresDTO.setCNPJ_FornecedoresDTO(rs.getString("CNPJ"));
                objFornecedoresDTO.setMaterial_FornecedoresDTO(rs.getString("Tipo_material"));
                objFornecedoresDTO.setEmail_FornecedoresDTO(rs.getString("Email"));
                objFornecedoresDTO.setTelefone_FornecedoresDTO(rs.getString("Telefone"));
                objFornecedoresDTO.setValor_FornecedoresDTO(rs.getString("Valor_material"));
                
                lista.add(objFornecedoresDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'FornecedoresDAO' - 'pesquisarFornecedores': " + erro);
        }
        
        return lista;
    }
}
