package model;

/**
 * Created by batman on 24/05/2016.
 */
public class MercenaryMatch extends Match {
    int price;
    int paid;

    public MercenaryMatch(){

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }
}
