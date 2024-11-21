package DTO;

/**
 *
 * @author Gabriel Possato
 */

public class ReservasDTO {
    
    private int IDCliente_Reservas, Capacidade_Reservas, IDFilial_Reservas;
    private String DataReserva_Reservas, Mesa_Reservas;    

    public int getIDCliente_Reservas() {
        return IDCliente_Reservas;
    }

    public void setIDCliente_Reservas(int IDCliente_Reservas) {
        this.IDCliente_Reservas = IDCliente_Reservas;
    }

    public int getCapacidade_Reservas() {
        return Capacidade_Reservas;
    }

    public void setCapacidade_Reservas(int Capacidade_Reservas) {
        this.Capacidade_Reservas = Capacidade_Reservas;
    }

    public int getIDFilial_Reservas() {
        return IDFilial_Reservas;
    }

    public void setIDFilial_Reservas(int IDFilial_Reservas) {
        this.IDFilial_Reservas = IDFilial_Reservas;
    }

    public String getDataReserva_Reservas() {
        return DataReserva_Reservas;
    }

    public void setDataReserva_Reservas(String DataReserva_Reservas) {
        this.DataReserva_Reservas = DataReserva_Reservas;
    }

    public String getMesa_Reservas() {
        return Mesa_Reservas;
    }

    public void setMesa_Reservas(String Mesa_Reservas) {
        this.Mesa_Reservas = Mesa_Reservas;
    }
}
