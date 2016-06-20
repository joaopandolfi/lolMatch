package beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Chat;
import model.Message;
import persistence.ChatDAO;

@ManagedBean(name="chatBean")
@SessionScoped
public class ChatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ChatDAO chatDAO;
	
	private int idToChat;
	private Chat chat;
	private ArrayList<Chat> chats = new ArrayList<Chat>();
	
	public ChatBean(){
		chatDAO = new ChatDAO();
	}
	
	public ArrayList<Chat> chatList(int idReceiver){
		chats = chatDAO.getAllChats(idReceiver);
		return chats;
	}
	
	public String toChat(int idToChat){
		setIdToChat(idToChat);
		return "chat";
	}
	
	public int getIdToChat() {
		return idToChat;
	}

	public void setIdToChat(int idToChat) {
		this.idToChat = idToChat;
		//ENVIA MSG
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}
	
}
