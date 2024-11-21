package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.ClienteDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class ClienteDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ClienteDTO> lista = new ArrayList<>();
    
    public void cadastrarCliente(ClienteDTO objClienteDTO) {
        String sql = "INSERT INTO Clientes (CPF, Nome, Sexo, Idade, Endereco, Email, Telefone, Data_cadastro) VALUES (?,?,?,?,?,?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            pstm.setString(1, objClienteDTO.getCPF_ClienteDTO());
            pstm.setString(2, objClienteDTO.getNome_ClienteDTO());
            pstm.setString(3, objClienteDTO.getSexo_ClienteDTO());
            pstm.setInt(4, objClienteDTO.getIdade_ClienteDTO());
            pstm.setString(5, objClienteDTO.getEndereço_ClienteDTO());
            pstm.setString(6, objClienteDTO.getEmail_ClienteDTO());
            pstm.setString(7, objClienteDTO.getTelefone_ClienteDTO());
            pstm.setString(8, objClienteDTO.getDataCadastro_ClienteDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'ClienteDAO': " + erro);
        }
    }
    
    public ArrayList<ClienteDTO> listarCliente() {
        String sql = "SELECT * FROM Clientes";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                ClienteDTO objClienteDTO = new ClienteDTO();
                objClienteDTO.setCPF_ClienteDTO(rs.getString("CPF"));
                objClienteDTO.setNome_ClienteDTO(rs.getString("Nome"));
                objClienteDTO.setSexo_ClienteDTO(rs.getString("Sexo"));
                objClienteDTO.setIdade_ClienteDTO(rs.getInt("Idade"));
                objClienteDTO.setEndereço_ClienteDTO(rs.getString("Endereco"));
                objClienteDTO.setEmail_ClienteDTO(rs.getString("Email"));
                objClienteDTO.setTelefone_ClienteDTO(rs.getString("Telefone"));
                objClienteDTO.setDataCadastro_ClienteDTO(rs.getString("Data_cadastro"));
                
                lista.add(objClienteDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'ClienteDAO' - 'listarCliente': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<ClienteDTO> pesquisarCliente(String valor, String item){
        String sql = "SELECT * FROM Clientes where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                ClienteDTO objClienteDTO = new ClienteDTO();
                objClienteDTO.setCPF_ClienteDTO(rs.getString("CPF"));
                objClienteDTO.setNome_ClienteDTO(rs.getString("Nome"));
                objClienteDTO.setSexo_ClienteDTO(rs.getString("Sexo"));
                objClienteDTO.setIdade_ClienteDTO(rs.getInt("Idade"));
                objClienteDTO.setEndereço_ClienteDTO(rs.getString("Endereco"));
                objClienteDTO.setEmail_ClienteDTO(rs.getString("Email"));
                objClienteDTO.setTelefone_ClienteDTO(rs.getString("Telefone"));
                objClienteDTO.setDataCadastro_ClienteDTO(rs.getString("Data_cadastro"));
                
                lista.add(objClienteDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'ClienteDAO' - 'pesquisarCliente': " + erro);
        }
        
        return lista;
    }
}
