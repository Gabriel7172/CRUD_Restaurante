package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.PedidosDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class PedidosDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PedidosDTO> lista = new ArrayList<>();
    
    public void cadastrarPedido(PedidosDTO objPedidosDTO) {
        String sql = "INSERT INTO Pedidos (ID_cliente, ID_prato, ID_bebida, Valor, Tipo_pagamento, Endereco, Data_pedido) VALUES (?,?,?,?,?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            
            pstm.setInt(1, objPedidosDTO.getIDCliente_PedidosDTO());
            pstm.setInt(2, objPedidosDTO.getIDPrato_PedidosDTO());
            pstm.setInt(3, objPedidosDTO.getIDBebida_PedidosDTO());
            pstm.setString(4, objPedidosDTO.getValor_PedidosDTO());
            pstm.setString(5, objPedidosDTO.getPagamento_PedidosDTO());
            pstm.setString(6, objPedidosDTO.getEndereço_PedidosDTO());
            pstm.setString(7, objPedidosDTO.getDataPedido_PedidosDTO());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'PedidosDAO': " + erro);
        }
    }
    
    public ArrayList<PedidosDTO> listarPedidos() {
        String sql = "SELECT * FROM Pedidos";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                PedidosDTO objPedidosDTO = new PedidosDTO();
                objPedidosDTO.setIDCliente_PedidosDTO(rs.getInt("ID_cliente"));
                objPedidosDTO.setIDPrato_PedidosDTO(rs.getInt("ID_prato"));
                objPedidosDTO.setIDBebida_PedidosDTO(rs.getInt("ID_bebida"));
                objPedidosDTO.setValor_PedidosDTO(rs.getString("Valor"));
                objPedidosDTO.setPagamento_PedidosDTO(rs.getString("Tipo_pagamento"));
                objPedidosDTO.setEndereço_PedidosDTO(rs.getString("Endereco"));
                objPedidosDTO.setDataPedido_PedidosDTO(rs.getString("Data_pedido"));
                
                lista.add(objPedidosDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'PedidosDAO' - 'listarPedidos': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<PedidosDTO> pesquisarPedidos(String valor, String item) {
        String sql = "SELECT * FROM Pedidos where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                PedidosDTO objPedidosDTO = new PedidosDTO();
                objPedidosDTO.setIDCliente_PedidosDTO(rs.getInt("ID_cliente"));
                objPedidosDTO.setIDPrato_PedidosDTO(rs.getInt("ID_prato"));
                objPedidosDTO.setIDBebida_PedidosDTO(rs.getInt("ID_bebida"));
                objPedidosDTO.setValor_PedidosDTO(rs.getString("Valor"));
                objPedidosDTO.setPagamento_PedidosDTO(rs.getString("Tipo_pagamento"));
                objPedidosDTO.setEndereço_PedidosDTO(rs.getString("Endereco"));
                objPedidosDTO.setDataPedido_PedidosDTO(rs.getString("Data_pedido"));
                
                lista.add(objPedidosDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'PedidosDAO' - 'pesquisarPedidos': " + erro);
        }
        
        return lista;
    }
}
