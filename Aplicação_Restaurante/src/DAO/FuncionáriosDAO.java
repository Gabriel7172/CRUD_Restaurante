package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.FuncionáriosDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class FuncionáriosDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionáriosDTO> lista = new ArrayList<>();
    
    public void cadastrarFuncionário(FuncionáriosDTO objFuncionáriosDTO) {
        String sql = "INSERT INTO Funcionarios (CPF, Nome, Sexo, Idade, Endereco, Email, Telefone, ID_filial, Cargo, Data_contratacao) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            pstm.setString(1, objFuncionáriosDTO.getCPF_FuncionáriosDTO());
            pstm.setString(2, objFuncionáriosDTO.getNome_FuncionáriosDTO());
            pstm.setString(3, objFuncionáriosDTO.getSexo_FuncionáriosDTO());
            pstm.setInt(4, objFuncionáriosDTO.getIdade_FuncionáriosDTO());
            pstm.setString(5, objFuncionáriosDTO.getEndereço_FuncionáriosDTO());
            pstm.setString(6, objFuncionáriosDTO.getEmail_FuncionáriosDTO());
            pstm.setString(7, objFuncionáriosDTO.getTelefone_FuncionáriosDTO());
            pstm.setInt(8, objFuncionáriosDTO.getIDFilial_FuncionáriosDTO());
            pstm.setString(9, objFuncionáriosDTO.getCargo_FuncionáriosDTO());
            pstm.setString(10, objFuncionáriosDTO.getDataContratação_FuncionáriosDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'FuncionáriosDAO': " + erro);
        }
    }
    
    public ArrayList<FuncionáriosDTO> listarFuncionários() {
        String sql = "SELECT * FROM Funcionarios";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                FuncionáriosDTO objFuncionáriosDTO = new FuncionáriosDTO();
                objFuncionáriosDTO.setCPF_FuncionáriosDTO(rs.getString("CPF"));
                objFuncionáriosDTO.setNome_FuncionáriosDTO(rs.getString("Nome"));
                objFuncionáriosDTO.setSexo_FuncionáriosDTO(rs.getString("Sexo"));
                objFuncionáriosDTO.setIdade_FuncionáriosDTO(rs.getInt("Idade"));
                objFuncionáriosDTO.setEndereço_FuncionáriosDTO(rs.getString("Endereco"));
                objFuncionáriosDTO.setEmail_FuncionáriosDTO(rs.getString("Email"));
                objFuncionáriosDTO.setIDFilial_FuncionáriosDTO(rs.getInt("ID_filial"));
                objFuncionáriosDTO.setCargo_FuncionáriosDTO(rs.getString("CPF"));
                objFuncionáriosDTO.setDataContratação_FuncionáriosDTO(rs.getString("Data_contratacao"));
                
                lista.add(objFuncionáriosDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'FuncionáriosDAO' - 'listarFuncionários': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<FuncionáriosDTO> pesquisarFuncionários(String valor, String item) {
        String sql = "SELECT * FROM Funcionarios where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                FuncionáriosDTO objFuncionáriosDTO = new FuncionáriosDTO();
                objFuncionáriosDTO.setCPF_FuncionáriosDTO(rs.getString("CPF"));
                objFuncionáriosDTO.setNome_FuncionáriosDTO(rs.getString("Nome"));
                objFuncionáriosDTO.setSexo_FuncionáriosDTO(rs.getString("Sexo"));
                objFuncionáriosDTO.setIdade_FuncionáriosDTO(rs.getInt("Idade"));
                objFuncionáriosDTO.setEndereço_FuncionáriosDTO(rs.getString("Endereco"));
                objFuncionáriosDTO.setEmail_FuncionáriosDTO(rs.getString("Email"));
                objFuncionáriosDTO.setIDFilial_FuncionáriosDTO(rs.getInt("ID_filial"));
                objFuncionáriosDTO.setCargo_FuncionáriosDTO(rs.getString("CPF"));
                objFuncionáriosDTO.setDataContratação_FuncionáriosDTO(rs.getString("Data_contratacao"));
                
                lista.add(objFuncionáriosDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'FuncionáriosDAO' - 'pesquisarFuncionários': " + erro);
        }
        
        return lista;
    }
}
