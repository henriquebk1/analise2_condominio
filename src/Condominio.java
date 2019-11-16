
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
public class Condominio {
    private String nome;
    private String cidade;
    private String bairro;
    private int numero;
    private ArrayList<Edificio> edificios;

    public Condominio(String nome, String cidade, String bairro, int numero, ArrayList<Edificio> edificios) {
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.edificios = edificios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    public void setEdificios(ArrayList<Edificio> edificios) {
        this.edificios = edificios;
    }
    
}
