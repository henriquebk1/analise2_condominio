
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
public class ApartamentoLuxo extends Apartamento{
    private String tipoLuminaria;
    private boolean geladeiraEmbutida;
    private boolean fogaoEmbutido;

    public ApartamentoLuxo(String tipoLuminaria, boolean geladeiraEmbutida, boolean fogaoEmbutido, int numeroApto, int andar, double rendaMedia, ArrayList<Morador> moradores) {
        super(numeroApto, andar, rendaMedia, moradores);
        this.tipoLuminaria = tipoLuminaria;
        this.geladeiraEmbutida = geladeiraEmbutida;
        this.fogaoEmbutido = fogaoEmbutido;
    }

    public String getTipoLuminaria() {
        return tipoLuminaria;
    }

    public void setTipoLuminaria(String tipoLuminaria) {
        this.tipoLuminaria = tipoLuminaria;
    }

    public boolean isGeladeiraEmbutida() {
        return geladeiraEmbutida;
    }

    public void setGeladeiraEmbutida(boolean geladeiraEmbutida) {
        this.geladeiraEmbutida = geladeiraEmbutida;
    }

    public boolean isFogaoEmbutido() {
        return fogaoEmbutido;
    }

    public void setFogaoEmbutido(boolean fogaoEmbutido) {
        this.fogaoEmbutido = fogaoEmbutido;
    }

    
}
