package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import constants.Config;
import controller.SearchControl;
import model.Player;
import riot.LolAPI;

@ManagedBean(name="searchBean")
@SessionScoped
public class SearchBean implements Serializable {
	private static final long serialVersionUID = 1L;
	SearchControl searchControl;
	LolAPI api = LolAPI.getInstance(Config.LOL_API);
	
	String nameSearch;
	ArrayList<Player> players;
	
	public SearchBean(){
		players = new ArrayList<Player>();
		searchControl = new SearchControl(api);
	}
	
	public String search(){
		
		return "";
	}
	
	public ArrayList<Player> mainSearch(String id){
		if(players.isEmpty())
			players = searchControl.searchByCriteria(Integer.parseInt(id));
		return players;
	}
	
// == Getters and Setters	

	
	public String getNameSearch() {
		return nameSearch;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}
	

}
