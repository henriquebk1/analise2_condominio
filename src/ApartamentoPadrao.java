
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique Becker
 */
public class ApartamentoPadrao extends Apartamento{
    private String tipoArmario;
    private String tipoPiso;

    public ApartamentoPadrao(String tipoArmario, String tipoPiso, int numeroApto, int andar, double rendaMedia, ArrayList<Morador> moradores) {
        super(numeroApto, andar, rendaMedia, moradores);
        this.tipoArmario = tipoArmario;
        this.tipoPiso = tipoPiso;
    }

    public String getTipoArmario() {
        return tipoArmario;
    }

    public void setTipoArmario(String tipoArmario) {
        this.tipoArmario = tipoArmario;
    }

    public String getTipoPiso() {
        return tipoPiso;
    }

    public void setTipoPiso(String tipoPiso) {
        this.tipoPiso = tipoPiso;
    }

    
}
