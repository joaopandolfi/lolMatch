package model;

/**
 * Created by joao on 6/9/16.
 * TODO: DEFINIR DADOS A SEREM BUSCADOS
 */
public class GameData {

    private String rank;


    //TODO: Implementar
    public static GameData jsonParser(String json){
        GameData gameData = new GameData();


        return  gameData;
    }


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}
