package model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by batman on 24/05/2016.
 */
public class Player {
    private String id;
    private long idGame;
    private String name;
    private String idInGame;
    private String title;
    private String userName;
    private double avaliation;
    private int valueWallet;
    private String rank;
    private int idTitle;
    private int profileIconId;
    private Wallet wallet;
    
    private GameData gameData;


    public Player(){
    	idInGame = "";
    }

    /*
    * @fingerPrint
    * @params {summonerId:{int},name:{String}}
    * */

    //TODO : FAZER
    public static Player jsonParser(String json){
        Player player = new Player();


        return player;
    }

    public void setDataByJson(String json){
    	if(json.equals("error_io"))
    		return;
        JSONObject jsonObject = new JSONObject(json);
        jsonObject = jsonObject.getJSONObject(name.toLowerCase().replaceAll(" ",""));
        idInGame = String.format("%d",jsonObject.getInt("id"));
        profileIconId = jsonObject.getInt("profileIconId");
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
        valueWallet = wallet.getSaldo();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getIdGame() {
        return idGame;
    }

    public String getStringIdGame(){
        return String.format("%d",idGame);
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateName(){
    	this.userName = title;
    }
    
    public String getIdInGame() {
        return idInGame;
    }

    public void setIdInGame(String idInGame) {
        this.idInGame = idInGame;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAvaliation() {
        return avaliation;
    }

    public void setAvaliation(double avaliation) {
        this.avaliation = avaliation;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getIdTitle() {
        return idTitle;
    }

    public void setIdTitle(int idTitle) {
        this.idTitle = idTitle;
    }

    public String getRank(){
        return rank;
    }

    public int getValueWallet(){
        return valueWallet;
    }

    public void setValueWallet(int valueWallet){
        this.valueWallet = valueWallet;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }
    
    public String getUserName(){
    	return userName;
    }

//Game Data Control

    public GameData getGameData(){
        return this.gameData;
    }

    public void setGameData(GameData gameData){
        this.gameData = gameData;
        rank = gameData.getLeague();
    }

    public void setGameDataByJson(String json){
        this.gameData = GameData.jsonParser(json,idInGame);
        rank = gameData.getLeague();
    }
}
