package DTO;

/**
 *
 * @author Gabriel Possato
 */

public class EntregasDTO {
    
    private String Endereço_EntregasDTO, DataEntrega_EntregasDTO;
    private int IDPedido_EntregasDTO;

    public String getEndereço_EntregasDTO() {
        return Endereço_EntregasDTO;
    }

    public void setEndereço_EntregasDTO(String Endereço_EntregasDTO) {
        this.Endereço_EntregasDTO = Endereço_EntregasDTO;
    }

    public String getDataEntrega_EntregasDTO() {
        return DataEntrega_EntregasDTO;
    }

    public void setDataEntrega_EntregasDTO(String DataEntrega_EntregasDTO) {
        this.DataEntrega_EntregasDTO = DataEntrega_EntregasDTO;
    }

    public int getIDPedido_EntregasDTO() {
        return IDPedido_EntregasDTO;
    }

    public void setIDPedido_EntregasDTO(int IDPedido_EntregasDTO) {
        this.IDPedido_EntregasDTO = IDPedido_EntregasDTO;
    }
}
