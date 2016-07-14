package controller;

import model.Item;
import model.Titulo;
import model.Wallet;
import persistence.ShopDAO;
import persistence.WalletDAO;

import java.util.ArrayList;

/**
 * Created by joao on 6/10/16.
 */
public class ShopControl {

    private ShopDAO shopDAO;
    private WalletDAO walletDAO;

    public ShopControl(){
        shopDAO = new ShopDAO();
        walletDAO = new WalletDAO();
    }

    /*
    * Recupera os itens da loja
    * @returns itens {ArrayList<Item>}
    * */
    private ArrayList<Item> getShopItens(){
        return null;
    }

    private ArrayList<Titulo> getShopTitles(){
        return null;
    }

    /*
    * Efetua compra de um item
    * @returns wallet {Wallet}
    * */
    public Wallet buyItem(Wallet wallet, Item item, int quant){
        if(wallet.getSaldo() >= (quant * item.getValue())){
            if(shopDAO.buyItem(wallet,item,quant)){
                wallet.addItem(item);
                wallet.discountValue(item.getValue());
                walletDAO.updateValue(wallet);
            }
        }
        return wallet;
    }

    /*
    * Efetua compra de um titulo
    * @returns wallet {Wallet}
    * */
    public Wallet buyTitulo(Wallet wallet, Titulo titulo){
        if(wallet.getSaldo() >= titulo.getValue()){
            if(shopDAO.buyTitle(wallet,titulo)){
                wallet.addTitulo(titulo);
                wallet.discountValue(titulo.getValue());
                walletDAO.updateValue(wallet);
            }
        }
        return  wallet;
    }
}
