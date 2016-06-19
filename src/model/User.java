package model;

/**
 * Created by joao on 6/9/16.
 */
public class User {
    private String name;
    private String login;
    private String pass;
    private boolean logged;
    private String id;
    private Player player;

    public void setLoginAndPass(String login, String pass){
        this.login = login;
        this.pass = pass;
    }

    public void setLogin(String login){
    	this.login = login;
    }
    
    public String getLogin(){
        return login;
    }

    public String getAndFlushPass(){
        String buffPass = pass;
        pass = "";
        return buffPass;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setLogged(){
        logged = true;
    }

    public void setPass(String pass){
    	this.pass = pass;
    }
    
    public String getPass(){
    	return this.pass;
    }
    
    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public boolean isLogged(){
        return logged;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
