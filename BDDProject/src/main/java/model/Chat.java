package model;

import java.util.ArrayList;

/**
 * Created by joao on 6/10/16.
 */
public class Chat {
    private int id_sender;
    private int id_receiver;
    private int idChat;
    private String nameUserFrom;
    private String nameUserSender;
    private ArrayList<Message> messages = new ArrayList<Message>();


    // ===  Messages Controller ===

    public void setMessages(ArrayList<Message> messages) {
        id_sender = -1;
        this.messages = messages;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    public void setAllMessagesReaded(){
        for(Message message: messages){
            message.readed();
        }
    }

    public void addTextMessage(String textMessage){
    	Message message = new Message();
    	message.setMessage(textMessage);
    	this.messages.add(message);
    }
    
    // ==== Getters and Setters ===

    public int getId_sender() {
        return id_sender;
    }

    public void setId_sender(int id_sender) {
        this.id_sender = id_sender;
    }

    public int getId_receiver() {
        return id_receiver;
    }

    public void setId_receiver(int id_receiver) {
        this.id_receiver = id_receiver;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

	public int getIdChat() {
		return idChat;
	}

	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}

	public String getNameUserFrom() {
		return nameUserFrom;
	}

	public void setNameUserFrom(String nameUserFrom) {
		this.nameUserFrom = nameUserFrom;
	}

	public String getNameUserSender() {
		return nameUserSender;
	}

	public void setNameUserSender(String nameUserSender) {
		this.nameUserSender = nameUserSender;
	}
}
