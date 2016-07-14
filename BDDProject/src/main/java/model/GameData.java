package model;

import org.json.JSONArray;
import org.json.JSONObject;

import constants.TypeGame;

/**
 * Created by joao on 6/9/16.
 * TODO: DEFINIR DADOS A SEREM BUSCADOS
 */
public class GameData {

    
    private int winRanked3x3;
    private int winRankedSolo5x5;
    private int winRankedTeam5x5;
    
    private String league;
    private String leagueName;
    private int win;
    private int losses;
    private int leaguePoints;
    
    //TODO: Implementar
    public static GameData jsonParser(String json,String userId){
    	GameData gameData = new GameData();
    	if(json.equals("error_io")){
        	gameData.setLeague(TypeGame.Unranked);
        	return gameData;
        }
        JSONObject response = new JSONObject(json);
        JSONArray ranks = response.getJSONArray(userId);
        JSONObject rankDataSolo5v5 = ranks.getJSONObject(0);
         
        rankDataSolo5v5.getString("queue");
        gameData.setLeagueName(rankDataSolo5v5.getString("name"));
        gameData.setLeague(rankDataSolo5v5.getString("tier"));
        
        JSONArray data5v5 = rankDataSolo5v5.getJSONArray("entries");
        JSONObject rankData5v5 = data5v5.getJSONObject(0);

        gameData.setLeaguePoints(rankData5v5.getInt("leaguePoints"));
        gameData.setLosses(rankData5v5.getInt("losses"));
        gameData.setWin(rankData5v5.getInt("wins"));

       return  gameData;
	 }

    private void populeByTypeGame(JSONObject result){
    	
    }

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getLeaguePoints() {
		return leaguePoints;
	}

	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}


}
