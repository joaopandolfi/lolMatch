package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="chatBean")
@SessionScoped
public class ChatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public int idToChat;
	
	public String toChat(int idToChat){
		setIdToChat(idToChat);
		return "chat";
	}
	
	public int getIdToChat() {
		return idToChat;
	}

	public void setIdToChat(int idToChat) {
		this.idToChat = idToChat;
	}

}
