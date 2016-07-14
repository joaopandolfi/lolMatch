package controller;

import model.Player;
import model.User;
import model.Wallet;
import persistence.PlayerDAO;
import persistence.UserDAO;
import persistence.WalletDAO;
import riot.LolAPI;
import riot.QueryMaker;

/**
 * Created by joao on 6/9/16.
 */
public class LoginControl {

    private LolAPI api;
    private Player loggedPlayer;
    private QueryMaker queryMaker;

    public LoginControl(LolAPI lolAPI){
        api = lolAPI;
        loggedPlayer = null;
        queryMaker = new QueryMaker();
    }

    public boolean login(User user){
        UserDAO userDAO = new UserDAO();
        PlayerDAO playerDAO = new PlayerDAO();
        User loggedUser = userDAO.login(user);
        if(loggedUser.isLogged()){
           // loggedPlayer = playerDAO.searchById(loggedUser.getId());
            loggedPlayer = user.getPlayer();
            loggedPlayer = loadWallet(loggedPlayer);
            loggedPlayer.setDataByJson(api.query(queryMaker.getSummonersByName(loggedUser.getPlayer().getName())));
            loggedPlayer.setGameDataByJson(api.query(queryMaker.getRankedDataById(loggedUser.getPlayer().getIdInGame())));
            return true;
        }

        return false;
    }

    public Player getLoggedPlayer(){
        return loggedPlayer;
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
