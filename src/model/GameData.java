package model;

import org.json.JSONObject;

/**
 * Created by joao on 6/9/16.
 * TODO: DEFINIR DADOS A SEREM BUSCADOS
 */
public class GameData {

    private String rank;
    private int win;
    private int losses;
    
    private int winRanked3x3;
    private int winRankedSolo5x5;
    private int winRankedTeam5x5;
    
    
    //TODO: Implementar
    public static GameData jsonParser(String json){
        GameData gameData = new GameData();


        return  gameData;
    }

    private void populeByTypeGame(JSONObject result){
    	
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}
