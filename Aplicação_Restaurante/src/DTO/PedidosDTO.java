package DTO;

/**
 *
 * @author Gabriel Possato
 */

public class PedidosDTO {
    
    private String Valor_PedidosDTO, Pagamento_PedidosDTO, Endereço_PedidosDTO, DataPedido_PedidosDTO;
    private int IDCliente_PedidosDTO, IDPrato_PedidosDTO, IDBebida_PedidosDTO;

    public String getValor_PedidosDTO() {
        return Valor_PedidosDTO;
    }

    public void setValor_PedidosDTO(String Valor_PedidosDTO) {
        this.Valor_PedidosDTO = Valor_PedidosDTO;
    }

    public String getPagamento_PedidosDTO() {
        return Pagamento_PedidosDTO;
    }

    public void setPagamento_PedidosDTO(String Pagamento_PedidosDTO) {
        this.Pagamento_PedidosDTO = Pagamento_PedidosDTO;
    }

    public String getEndereço_PedidosDTO() {
        return Endereço_PedidosDTO;
    }

    public void setEndereço_PedidosDTO(String Endereço_PedidosDTO) {
        this.Endereço_PedidosDTO = Endereço_PedidosDTO;
    }

    public String getDataPedido_PedidosDTO() {
        return DataPedido_PedidosDTO;
    }

    public void setDataPedido_PedidosDTO(String DataPedido_PedidosDTO) {
        this.DataPedido_PedidosDTO = DataPedido_PedidosDTO;
    }

    public int getIDCliente_PedidosDTO() {
        return IDCliente_PedidosDTO;
    }

    public void setIDCliente_PedidosDTO(int IDCliente_PedidosDTO) {
        this.IDCliente_PedidosDTO = IDCliente_PedidosDTO;
    }

    public int getIDPrato_PedidosDTO() {
        return IDPrato_PedidosDTO;
    }

    public void setIDPrato_PedidosDTO(int IDPrato_PedidosDTO) {
        this.IDPrato_PedidosDTO = IDPrato_PedidosDTO;
    }

    public int getIDBebida_PedidosDTO() {
        return IDBebida_PedidosDTO;
    }

    public void setIDBebida_PedidosDTO(int IDBebida_PedidosDTO) {
        this.IDBebida_PedidosDTO = IDBebida_PedidosDTO;
    }
}
