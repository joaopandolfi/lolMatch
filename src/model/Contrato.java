package model;

/**
 * Created by joao on 6/10/16.
 */
public class Contrato {
    private int value;
    private String date;
    private int id_contractor;
    private int id_contrated;

    public Contrato(){

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_contractor() {
        return id_contractor;
    }

    public void setId_contractor(int id_contractor) {
        this.id_contractor = id_contractor;
    }

    public int getId_contrated() {
        return id_contrated;
    }

    public void setId_contrated(int id_contrated) {
        this.id_contrated = id_contrated;
    }
}
