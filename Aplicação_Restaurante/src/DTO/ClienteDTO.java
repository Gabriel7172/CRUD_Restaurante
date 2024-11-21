package DTO;

/**
 *
 * @author Gabriel Possato
 */

public class ClienteDTO {
    
    private String CPF_ClienteDTO, Nome_ClienteDTO, Sexo_ClienteDTO, Endereço_ClienteDTO, Email_ClienteDTO, Telefone_ClienteDTO, DataCadastro_ClienteDTO;
    private int Idade_ClienteDTO;
    
    public String getCPF_ClienteDTO() {
        return CPF_ClienteDTO;
    }

    public void setCPF_ClienteDTO(String CPF_ClienteDTO) {
        this.CPF_ClienteDTO = CPF_ClienteDTO;
    }

    public String getNome_ClienteDTO() {
        return Nome_ClienteDTO;
    }

    public void setNome_ClienteDTO(String Nome_ClienteDTO) {
        this.Nome_ClienteDTO = Nome_ClienteDTO;
    }

    public String getSexo_ClienteDTO() {
        return Sexo_ClienteDTO;
    }

    public void setSexo_ClienteDTO(String Sexo_ClienteDTO) {
        this.Sexo_ClienteDTO = Sexo_ClienteDTO;
    }

    public int getIdade_ClienteDTO() {
        return Idade_ClienteDTO;
    }

    public void setIdade_ClienteDTO(int Idade_ClienteDTO) {
        this.Idade_ClienteDTO = Idade_ClienteDTO;
    }

    public String getEndereço_ClienteDTO() {
        return Endereço_ClienteDTO;
    }

    public void setEndereço_ClienteDTO(String Endereço_ClienteDTO) {
        this.Endereço_ClienteDTO = Endereço_ClienteDTO;
    }

    public String getEmail_ClienteDTO() {
        return Email_ClienteDTO;
    }

    public void setEmail_ClienteDTO(String Email_ClienteDTO) {
        this.Email_ClienteDTO = Email_ClienteDTO;
    }

    public String getTelefone_ClienteDTO() {
        return Telefone_ClienteDTO;
    }

    public void setTelefone_ClienteDTO(String Telefone_ClienteDTO) {
        this.Telefone_ClienteDTO = Telefone_ClienteDTO;
    }

    public String getDataCadastro_ClienteDTO() {
        return DataCadastro_ClienteDTO;
    }

    public void setDataCadastro_ClienteDTO(String DataCadastro_ClienteDTO) {
        this.DataCadastro_ClienteDTO = DataCadastro_ClienteDTO;
    }
}
