package controller;

import model.Message;
import persistence.ChatDAO;

import java.util.ArrayList;

/**
 * Created by joao on 6/10/16.
 */
public class ChatControl {

	ChatDAO chatDao = new ChatDAO();
    public ChatControl(){
    }

    public boolean sendMessageTo(int idchat,Message message){
    	return chatDao.sendMessage(idchat, message);
    }

    public ArrayList<Message> getMessages(int idReceiver){

        return null;
    }
    
    //Cria um novo chat
    public boolean newChatConversation(int from, int to){
    	System.out.println(String.format("Creating Chat -> From %d To %d", from,to));
    	return chatDao.createChat(from, to);
    }
}
