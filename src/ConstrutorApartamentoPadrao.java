
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
public class ConstrutorApartamentoPadrao extends ConstrutorApartamento{
    public ApartamentoPadrao construitApartamento(String tipoArmario, String tipoPiso, int numeroApto, int andar, double rendaMedia, ArrayList<Morador> moradores){
        return new ApartamentoPadrao(tipoArmario, tipoPiso, numeroApto, andar, rendaMedia, moradores);
    }
    
    @Override
    public Apartamento construirApartamento(int numeroApto, int andar, double rendaMedia, ArrayList<Morador> moradores) {
        return new ApartamentoPadrao("", "", numeroApto, andar, rendaMedia, moradores);
    }
    
}
