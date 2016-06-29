package persistence;

import model.Wallet;

/**
 * Created by joao on 6/19/16.
 */
public class WalletDAO extends DAO{

    /*
    * Atualiza o valor da carteira
    * @param wallet {Wallet}
    * @returns boolean {Boolean}
    * */
    public boolean updateValue(Wallet wallet){
        try {
            open();

            stmt = con.prepareStatement("UPDATE carteira SET valor = ? WHERE idcarteira = ?");
            stmt.setInt(1, wallet.getSaldo());
            stmt.setInt(2, wallet.getId());
            stmt.execute();

            close();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /*
    * Busca o valor da carteira
    * @param wallet {Wallet}
    * @returns int {int}
    * */
    public int getValue(Wallet wallet){
        int value = -1;
        try {
            open();
            stmt = con.prepareStatement("SELECT valor FROM carteira WHERE idcarteira = ?");
            stmt.setInt(1,wallet.getId());
            rs = stmt.executeQuery();

            while(rs.next()){
                value = rs.getInt("value");
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    /*
    * Busca carteira
    * @param idUser {int}
    * @returns wallet {Wallet}
    * */
    public Wallet getWallet(int idUser){
        Wallet wallet = new Wallet();
        try {
            open();
            stmt = con.prepareStatement("SELECT valor, idcarteira FROM carteira WHERE usuario_idusuario = ?");
            stmt.setInt(1,idUser);
            rs = stmt.executeQuery();

            while(rs.next()){
                wallet.setSaldo(rs.getInt("valor"));
                wallet.setId(rs.getInt("idcarteira"));
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wallet;
    }
}
