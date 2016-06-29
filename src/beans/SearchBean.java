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
	
	public String mainSearch(String id,String rank){
		if(id.equals(""))
			return "";
		if(players.isEmpty())
			players = searchControl.searchByCriteria(Integer.parseInt(id),rank);
		return "";
	}
	
	
	/*
	 * @toREPLACE	%idIngame%, %userName%, %idUser%, 
 	 * */
	public String makeFind(){
		String find = "";
		String tmp = "";
		boolean first = true;
		String modelCardFind = "<div class='item %class%'>"+
				"<!-- Profile Image -->"+
				"<div class='col-md-4 col-md-offset-2'>"+
					"<div class='box box-solid'>"+
						"<div class='box-body box-profile'>"+
							"<img class='profile-user-img img-responsive img-circle' src='http://vignette4.wikia.nocookie.net/leagueoflegends/images/7/75/ProfileIcon23.jpg/revision/latest?cb=20110527180255' alt='User profile picture'/>"+
							"<h3 class='profile-username text-center'>%userName%</h3>"+
							"<p class='text-muted text-center'>%idInGame%</p>"+

							"<ul class='list-group list-group-unbordered'>"+
								"<li class='list-group-item'>"+
									"<b>%league%</b> <a class='pull-right'>%leaguePoints% League Points</a>"+
								"</li>"+
								"<li class='list-group-item'>"+
									"<b>Wins</b> <a class='pull-right'>%win%</a>"+
								"</li>"+
								"<li class='list-group-item'>"+
									"<b>Play since</b> <a class='pull-right'>Season VI</a>"+
								"</li>"+
							"</ul>"+
							"<a href='./chat.jsf?new=1&to=%idUser%' class='btn btn-primary btn-block'><b>Talk</b></a>"+
						"</div><!-- /.box-body -->"+
					"</div><!-- /.box -->"+
				"</div>"+

				"<div class='col-md-4'>"+
					"<!-- About Me Box -->"+
					"<div class='box box-solid'>"+
						"<div class='box-header with-border'>"+
							"<h3 class='box-title'>About Me</h3>"+
						"</div><!-- /.box-header -->"+
						"<div class='box-body'>"+
							"<strong><i class='fa fa-map-marker margin-r-5'></i> Location</strong>"+
							"<p class='text-muted'>Espirito Santo, Brazil</p>"+

							"<hr/>"+

							"<strong><i class='fa fa-pencil margin-r-5'></i> Skills</strong>"+
							"<p>"+
								"<span class='label label-danger'>MID</span>"+
								"<span class='label label-warning'>Support</span>"+
								"<span class='label label-primary'>Top</span>"+
							"</p>"+

							"<hr/>"+

							"<strong><i class='fa fa-file-text-o margin-r-5'></i> Notes</strong>"+
							"<p>I'm a profissional player on game, made streams all days, at 14:00 pm.</p>"+

							"<hr/>"+

							"<strong><i class='fa fa-play margin-r-5'></i> Avaliation</strong>"+
							"<p>"+
							"%avaliation%"+
							"(%playerAvaliation%)"+
							"</p>"+
						"</div><!-- /.box-body -->"+
					"</div><!-- /.box -->"+
				"</div>	"+
			"</div>";


		for(Player player: players){
			tmp = modelCardFind.replaceAll("%idInGame%", player.getName());
			tmp = tmp.replaceAll("%userName%", player.getUserName());
			tmp = tmp.replaceAll("%idUser%", player.getId());
			tmp = tmp.replaceAll("%league%", player.getGameData().getLeague());
			tmp = tmp.replaceAll("%leaguePoints%", String.format("%d",player.getGameData().getLeaguePoints()));
			tmp = tmp.replaceAll("%win%", String.format("%d",player.getGameData().getWin()));
			tmp = tmp.replaceAll("%playerAvaliation%", String.format("%s",player.getAvaliation()));
			tmp = tmp.replaceAll("%avaliation%", MainBean.makeAvaliationStars(player.getAvaliation()));
			if(first){
				tmp = tmp.replaceAll("%class%", "active");
				first = false;
			}
			else
				tmp = tmp.replaceAll("%class%", "");
			
			find += tmp;
		}
		
		return find;
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
