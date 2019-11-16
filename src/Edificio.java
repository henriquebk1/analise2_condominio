
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
public class Edificio {
    private int numeroEdificio;
    private String cor;
    private int quantidadeAndares;
    private ArrayList<Apartamento> apartamentos;

    public Edificio(int numeroEdificio, String cor, int quantidadeAndares, ArrayList<Apartamento> apartamentos) {
        this.numeroEdificio = numeroEdificio;
        this.cor = cor;
        this.quantidadeAndares = quantidadeAndares;
        this.apartamentos = apartamentos;
    }

    public int getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(int numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuantidadeAndares() {
        return quantidadeAndares;
    }

    public void setQuantidadeAndares(int quantidadeAndares) {
        this.quantidadeAndares = quantidadeAndares;
    }

    public ArrayList<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(ArrayList<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }
    
}
