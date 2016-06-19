package persistence;

import model.Titulo;

import java.util.ArrayList;

/**
 * Created by joao on 6/19/16.
 */
public class TituloDAO extends DAO{

    /*
    * Retorna titulos por sql
    * @returns ititulos {ArrayList<Titulo>}
    * */
    private ArrayList<Titulo> consultTitlesSql(String sql){
        ArrayList<Titulo> titulos = new ArrayList<Titulo>();
        Titulo titulo;
        try {
            open();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                titulo = new Titulo();
                titulo.setName(rs.getString("nome"));
                titulo.setId(rs.getInt("idtitulo"));
                titulo.setValue(rs.getInt("valor"));
                titulos.add(titulo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return titulos;
    }

    /*
    * Retorna todos os titulos da loja
    * @returns titulos  {ArrayList<Titulo>}
    * */
    public ArrayList<Titulo> getTitles(){
        return consultTitlesSql("SELECT * FROM titulos");
    }

    /*
    * Retorna os titulos comprados pelo usuario
    * @params id_wallet
    * @returns boughtTitles {ArrayList<titulo>}
    * */
    public ArrayList<Titulo> getBoughtTitles(int id_wallet){
        return consultTitlesSql("SELECT t.nome, t.valor, t.idtitulo FROM titulo AS t INNER JOIN tituloscomprados AS tc ON tc.titulo_idtitulo = t.idtitulo WHERE tc.carteira_idcarteira = "+id_wallet);
    }

    /*
    * Retorna os Titulos que ainda não foram comprados pelo usuario
    * @params id_wallet
    * @returns boughtTitles {ArrayList<Title>}
    * */
    public ArrayList<Titulo> getNotBoughtTitles(int id_wallet){
        return consultTitlesSql("SELECT t.nome, t.valor, t.idtitulo FROM titulo AS t INNER JOIN tituloscomprados AS tc ON tc.titulo_idtitulo = t.idtitulo WHERE tc.carteira_idcarteira <> "+id_wallet);
    }

}
