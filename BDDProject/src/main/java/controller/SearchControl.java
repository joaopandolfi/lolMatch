package controller;

import java.util.ArrayList;

import model.Player;
import model.Wallet;
import persistence.PlayerDAO;
import persistence.WalletDAO;
import riot.LolAPI;
import riot.QueryMaker;

/**
 * Created by joao on 6/9/16.
 */
public class SearchControl {

    LolAPI api;
    QueryMaker queryMaker;
    PlayerDAO playerDAO;
    
    public SearchControl(LolAPI lolAPI){
    	playerDAO = new PlayerDAO();
    	api = lolAPI;
    	queryMaker = new QueryMaker();
    }
    
    /*
    * Busca o player de acordo com o padrão de ranqueamento
    * @returns player {Player}
    * */
    public ArrayList<Player> searchByCriteria(int userId,String rank){
        ArrayList<Player> players = playerDAO.getAll(userId);
        
        for(Player player: players){
        	player.setDataByJson(api.query(queryMaker.getSummonersByName(player.getName())));
        	player.updateName();
            player.setGameDataByJson(api.query(queryMaker.getRankedDataById(player.getIdInGame())));
        }

        return filterPlayers(players,rank);
    }

    //Retorna somente os que possuirem o mesmo elo
    private ArrayList<Player> filterPlayers(ArrayList<Player> players, String rank){
    	ArrayList<Player> filtered = new ArrayList<Player>();
    	
    	for(Player player:players){
    		if(player.getGameData().getLeague().equals(rank))
    			filtered.add(player);
    	}
    	return filtered;
    }
    
    /*
    * Busca o player pelo nome de invocador
    * @param name {String}
    * @returns player {Player}
    * */
    public Player searchByName(String name){
        Player playerReturned = new Player();
        playerReturned.setName(name);
        playerReturned.setDataByJson(api.query(queryMaker.getSummonersByName(name)));
        //Player player = playerDAO.searchByApiId(playerReturned.getStringIdGame());
        playerReturned.updateName();
        playerReturned.setGameDataByJson(api.query(queryMaker.getPlayerStatusById(playerReturned.getStringIdGame())));
        return playerReturned;
    }
        
    /*
    * Retorna o valor da carteira para o usuario
    * */
    private Player loadWallet(Player player){
        WalletDAO walletDAO = new WalletDAO();
        Wallet wallet = walletDAO.getWallet(Integer.parseInt(player.getId()));
        player.setWallet(wallet);
        return player;
    }

}
