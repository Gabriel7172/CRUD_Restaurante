package DTO;

/**
 *
 * @author Gabriel Possato
 */

public class FilialDTO {
    
    private String Endereço_FiliaisDTO, Email_FiliaisDTO, Telefone_FiliaisDTO, Avaliação_FiliaisDTO;
    private int QtndMesas_FiliaisDTO;

    public String getEndereço_FiliaisDTO() {
        return Endereço_FiliaisDTO;
    }

    public void setEndereço_FiliaisDTO(String Endereço_FiliaisDTO) {
        this.Endereço_FiliaisDTO = Endereço_FiliaisDTO;
    }

    public String getEmail_FiliaisDTO() {
        return Email_FiliaisDTO;
    }

    public void setEmail_FiliaisDTO(String Email_FiliaisDTO) {
        this.Email_FiliaisDTO = Email_FiliaisDTO;
    }

    public String getTelefone_FiliaisDTO() {
        return Telefone_FiliaisDTO;
    }

    public void setTelefone_FiliaisDTO(String Telefone_FiliaisDTO) {
        this.Telefone_FiliaisDTO = Telefone_FiliaisDTO;
    }

    public String getAvaliação_FiliaisDTO() {
        return Avaliação_FiliaisDTO;
    }

    public void setAvaliação_FiliaisDTO(String Avaliação_FiliaisDTO) {
        this.Avaliação_FiliaisDTO = Avaliação_FiliaisDTO;
    }

    public int getQtndMesas_FiliaisDTO() {
        return QtndMesas_FiliaisDTO;
    }

    public void setQtndMesas_FiliaisDTO(int QtndMesas_FiliaisDTO) {
        this.QtndMesas_FiliaisDTO = QtndMesas_FiliaisDTO;
    }
}
