
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
public abstract class ConstrutorApartamento {
    public abstract Apartamento construirApartamento(int numeroApto, int andar, double rendaMedia, ArrayList<Morador> moradores);
}
