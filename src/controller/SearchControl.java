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
    public ArrayList<Player> searchByCriteria(int userId){
        ArrayList<Player> players = playerDAO.getAll(userId);
        
        for(Player player: players){
        	player.jsonParser(api.query(queryMaker.getSummonersByName(player.getName())));
            player.setGameDataByJson(api.query(queryMaker.getPlayerStatusById(player.getId())));
        }

        return players;
    }

    /*
    * Busca o player pelo nome de invocador
    * @param name {String}
    * @returns player {Player}
    * */
    public Player searchByName(String name){
        Player playerReturned = Player.jsonParser(api.query(queryMaker.getSummonersByName(name)));
        Player player = playerDAO.searchByApiId(playerReturned.getStringIdGame());
        player.setGameDataByJson(api.query(queryMaker.getPlayerStatusById(playerReturned.getStringIdGame())));
        return player;
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
