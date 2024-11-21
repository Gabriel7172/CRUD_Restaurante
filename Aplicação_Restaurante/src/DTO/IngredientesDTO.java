package DTO;

/**
 *
 * @author Gabriel Possato
 */

public class IngredientesDTO {
    
    private String Nome_IngredientesDTO, UnidadeMedida_IngredientesDTO;
    private int IDPrato_IngredientesDTO, IDBebida_IngredientesDTO;

    public String getNome_IngredientesDTO() {
        return Nome_IngredientesDTO;
    }

    public void setNome_IngredientesDTO(String Nome_IngredientesDTO) {
        this.Nome_IngredientesDTO = Nome_IngredientesDTO;
    }

    public String getUnidadeMedida_IngredientesDTO() {
        return UnidadeMedida_IngredientesDTO;
    }

    public void setUnidadeMedida_IngredientesDTO(String UnidadeMedida_IngredientesDTO) {
        this.UnidadeMedida_IngredientesDTO = UnidadeMedida_IngredientesDTO;
    }

    public int getIDPrato_IngredientesDTO() {
        return IDPrato_IngredientesDTO;
    }

    public void setIDPrato_IngredientesDTO(int IDPrato_IngredientesDTO) {
        this.IDPrato_IngredientesDTO = IDPrato_IngredientesDTO;
    }

    public int getIDBebida_IngredientesDTO() {
        return IDBebida_IngredientesDTO;
    }

    public void setIDBebida_IngredientesDTO(int IDBebida_IngredientesDTO) {
        this.IDBebida_IngredientesDTO = IDBebida_IngredientesDTO;
    }
}
