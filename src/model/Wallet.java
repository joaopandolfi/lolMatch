package model;

import java.util.ArrayList;

/**
 * Created by joao on 6/10/16.
 */
public class Wallet {
    private int id;
    private int saldo;
    private ArrayList<Item> itens;
    private ArrayList<Titulo> titulos;

    public Wallet(){
        itens = new ArrayList<Item>();
        titulos = new ArrayList<Titulo>();
    }

    // === Itens controls ===

    public void addItem(Item item){
        this.itens.add(item);
    }

    public void addTitulo(Titulo titulo){
        this.titulos.add(titulo);
    }


    public void discountValue(int value){
        saldo = saldo - value;
    }

    public void depositValue(int value){
        saldo = saldo + value;
    }

    // === Getters and Setters ===

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public ArrayList<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(ArrayList<Titulo> titulos) {
        this.titulos = titulos;
    }
}
