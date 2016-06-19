package model;

import java.util.ArrayList;

/**
 * Created by joao on 6/10/16.
 */
public class Chat {
    private int id_sender;
    private int id_receiver;
    private ArrayList<Message> messages;


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
}
