package DAO;

import java.sql.*;

import java.util.ArrayList;
import DTO.ReservasDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Possato
 */

public class ReservasDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ReservasDTO> lista = new ArrayList<>();
    
    public void cadastrarReserva(ReservasDTO objReservasDTO) {
        String sql = "INSERT INTO Reservas (Data_reserva, ID_cliente, Mesa, ID_filial, Capacidade) VALUES (?,?,?,?,?)";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql); 
            
            pstm.setString(1, objReservasDTO.getDataReserva_Reservas());
            pstm.setInt(2, objReservasDTO.getIDCliente_Reservas());
            pstm.setString(3, objReservasDTO.getMesa_Reservas());
            pstm.setInt(4, objReservasDTO.getIDFilial_Reservas());
            pstm.setInt(5, objReservasDTO.getCapacidade_Reservas());
            
            pstm.execute();
            pstm.close();
        }
        
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'ReservasDAO': " + erro);
        }
    }
    
    public ArrayList<ReservasDTO> listarReservas() {
        String sql = "SELECT * FROM Reservas";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                ReservasDTO objReservasDTO = new ReservasDTO();
                objReservasDTO.setDataReserva_Reservas(rs.getString("Data_reserva"));
                objReservasDTO.setIDCliente_Reservas(rs.getInt("ID_cliente"));
                objReservasDTO.setMesa_Reservas(rs.getString("Mesa"));
                objReservasDTO.setIDFilial_Reservas(rs.getInt("ID_filial"));
                objReservasDTO.setCapacidade_Reservas(rs.getInt("Capacidade"));
                
                lista.add(objReservasDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'ReservasDAO' - 'listarReservas': " + erro);
        }
        
        return lista;
    }
    
    public ArrayList<ReservasDTO> pesquisarReservas(String valor, String item) {
        String sql = "SELECT * FROM Reservas where " + item + " like '%" + valor + "%'";
        
        conn = new ConexãoDAO().connectorDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                ReservasDTO objReservasDTO = new ReservasDTO();
                objReservasDTO.setDataReserva_Reservas(rs.getString("Data_reserva"));
                objReservasDTO.setIDCliente_Reservas(rs.getInt("ID_cliente"));
                objReservasDTO.setMesa_Reservas(rs.getString("Mesa"));
                objReservasDTO.setIDFilial_Reservas(rs.getInt("ID_filial"));
                objReservasDTO.setCapacidade_Reservas(rs.getInt("Capacidade"));
                
                lista.add(objReservasDTO);
            }
            
        } 
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo 'ReservasDAO' - 'pesquisarReservas': " + erro);
        }
        
        return lista;
    }
}
