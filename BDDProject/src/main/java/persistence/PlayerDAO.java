package persistence;

import java.util.ArrayList;

import model.Item;
import model.Player;

/**
 * Created by batman on 24/05/2016.
 */
public class PlayerDAO extends DAO{

    public PlayerDAO(){

    }

    public void save(Player player){

    }

    public ArrayList<Player> getAll(int idUsuario){
    	ArrayList<Player> players = new ArrayList<Player>();
    	Player player;
    	try {
            open();
            stmt = con.prepareStatement("SELECT u.idusuario, u.nome, l.idingame, l.avaliacao FROM usuario AS u INNER JOIN lolaccount AS l ON l.idlolaccount = u.lolaccount_idlolaccount WHERE u.idusuario <> "+idUsuario);
            rs = stmt.executeQuery();

            while(rs.next()) {
                player = new Player();
                player.setName(rs.getString("idingame"));
                player.setTitle(rs.getString("nome"));
                player.setAvaliation(rs.getInt("avaliacao"));
                player.setId(rs.getString("idusuario"));
                players.add(player);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    	return players;
    }
    
    public Player searchById(String id){
        return null;
    }

    public Player searchByApiId(String apiId){

        return null;
    }
}
