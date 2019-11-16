
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
public class ConstructorApartamentoLuxo extends ConstrutorApartamento{
    public ApartamentoLuxo construirApartamento(String tipoLuminaria, boolean geladeiraEmbutida, boolean fogaoEmbutido, int numeroApto, int andar, double rendaMedia, ArrayList<Morador> moradores) {
        return new ApartamentoLuxo(tipoLuminaria, geladeiraEmbutida, fogaoEmbutido, numeroApto, andar, rendaMedia, moradores);
    }

    @Override
    public Apartamento construirApartamento(int numeroApto, int andar, double rendaMedia, ArrayList<Morador> moradores) {
        return new ApartamentoLuxo("", false, false, numeroApto, andar, rendaMedia, moradores);
    }
    
}
