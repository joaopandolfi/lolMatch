package persistence;

import model.Item;
import model.Titulo;
import model.Wallet;

/**
 * Created by joao on 6/19/16.
 */
public class ShopDAO extends DAO {

    /*
    * Compra Item
    * @param wallet {Wallet}
    * @param item {Item}
    * @param quant {int}
    * @return boolean {Boolena}
    * */
    public boolean buyItem(Wallet wallet, Item item,int quant){
        try {
            open();

            stmt = con.prepareStatement("INSERT INTO itenscomprados(quantidade, carteira_idcarteira, itens_iditens) VALUES(?,?,?)");
            stmt.setInt(1, quant);
            stmt.setInt(2, wallet.getId());
            stmt.setString(3, item.getId());
            stmt.execute();
            close();
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
        return true;
    }

    /*
    * Compra titulo
    * @param wallet {Wallet}
    * @param titulo {Titutlo}
    * @return boolean {Boolena}
    * */
    public boolean buyTitle(Wallet wallet, Titulo titulo){
        try {
            open();

            stmt = con.prepareStatement("INSERT INTO tituloscomprados(carteira_idcarteira, titulo_idtitulo) VALUES(?,?)");
            stmt.setInt(1, wallet.getId());
            stmt.setInt(2, titulo.getId());
            stmt.execute();
            close();
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
        return true;
    }
}
