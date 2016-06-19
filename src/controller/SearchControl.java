package controller;

import model.Player;
import persistence.PlayerDAO;
import riot.LolAPI;
import riot.QueryMaker;

/**
 * Created by joao on 6/9/16.
 */
public class SearchControl {

    LolAPI api;
    QueryMaker queryMaker;

    /*
    * Busca o player de acordo com o padrão de ranqueamento
    * @returns player {Player}
    * */
    public Player searchByCriteria(){
        Player player = new Player();

        return player;
    }

    /*
    * Busca o player pelo nome de invocador
    * @param name {String}
    * @returns player {Player}
    * */
    public Player searchByName(String name){
        PlayerDAO playerDAO = new PlayerDAO();
        Player playerReturned = Player.jsonParser(api.query(queryMaker.getSummonersByName(name)));
        Player player = playerDAO.searchByApiId(playerReturned.getStringIdGame());
        player.setGameDataByJson(api.query(queryMaker.getPlayerStatusById(playerReturned.getStringIdGame())));
        return player;
    }
}
