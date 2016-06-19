package persistence;

import model.Item;

import java.util.ArrayList;

/**
 * Created by joao on 6/10/16.
 */
public class ItemDAO extends DAO {

    /*
    * Retorna itens por sql
    * @returns itens {ArrayList<Item>}
    * */
    private ArrayList<Item> consultItensSql(String sql){
        ArrayList<Item> itens = new ArrayList<Item>();
        Item item;
        try {
            open();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                item = new Item();
                item.setName(rs.getString("nome"));
                item.setId(rs.getInt("iditens"));
                item.setEffect(rs.getInt("effect"));
                item.setValue(rs.getInt("valor"));
                itens.add(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return itens;
    }

    /*
    * Retorna todos os itens da loja
    * @returns itens {ArrayList<Item>}
    * */
    public ArrayList<Item> getItens(){
        return consultItensSql("SELECT * FROM itens");
    }

    /*
    * Retorna os itens comprados pelo usuario
    * @params id_wallet
    * @returns boughtItens {ArrayList<Item>}
    * */
    public ArrayList<Item> getBoughtItens(int id_wallet){
        return consultItensSql("SELECT it.nome, it.efeito, it.iditens, it.valor FROM itens as it INNER JOIN itenscomprados AS ic ON ic.itens_iditens = it.iditens WHERE carteira_idcarteira = "+id_wallet);
    }

    /*
    * Retorna os itens que ainda não foram comprados pelo usuario
    * @params id_wallet
    * @returns boughtItens {ArrayList<Item>}
    * */
    public ArrayList<Item> getNotBoughtItens(int id_wallet){
        return consultItensSql("SELECT it.nome, it.efeito, it.iditens, it.valor FROM itens as it INNER JOIN itenscomprados AS ic ON ic.itens_iditens = it.iditens WHERE carteira_idcarteira <> "+id_wallet);
    }
}
