package controller;

import model.Wallet;
import persistence.WalletDAO;

/**
 * Created by joao on 6/10/16.
 */
public class WalletControl {

    private WalletDAO walletDAO;
    private Wallet wallet;

    public WalletControl(Wallet wallet){
        this.wallet = wallet;
        walletDAO = new WalletDAO();
    }

    /*
    * Tansfere uma quantia apra outra carteira
    * @parm idReceiver {int}
    * @param value {int}
    * @returns boolean
    * */
    public boolean transferValue(int idReceiver, int value){
        if(wallet.getSaldo() < value)
            return false;

        Wallet receiver = walletDAO.getWallet(idReceiver);
        receiver.depositValue(value);
        wallet.discountValue(value);

        walletDAO.updateValue(receiver);
        return walletDAO.updateValue(wallet);
    }

    /*
    * Deposita uma quantida na carteira
    * @param value {int}
    * @returns boolean
    * */
    public boolean depositValue(int value){
        wallet.depositValue(value);
        return walletDAO.updateValue(wallet);
    }

    /*
    * Desconta uma quantida da carteira
    * @param value {int}
    * @returns boolean
    * */
    public boolean discountValue(int value){
        if(wallet.getSaldo() < value)
            return false;

        wallet.discountValue(value);
        return walletDAO.updateValue(wallet);
    }

}
