package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controller.ChatControl;
import model.Chat;
import model.Message;
import persistence.ChatDAO;

@ManagedBean(name="chatBean")
@SessionScoped
public class ChatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ChatDAO chatDAO;
	
	private int idSender;
	private Chat chat;
	ChatControl chatControl = new ChatControl();
	private ArrayList<Chat> chats = new ArrayList<Chat>();
	
	public ChatBean(){
		chatDAO = new ChatDAO();
	}
	
	public String findChats(){
		chats = chatDAO.getAllChats(idSender);
		return makeChats();
	}
	
	public String setSender(int idSender){
		this.idSender = idSender;
		return "";
	}
		
	/*
	 * Verifica os parametros vindos pela URL
	 * @param new {integer}
	 * @param to {integer}
	 * @example ?new=1&to=2
	 */
	public String checkParams(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(params.containsKey("new"))
			chatControl.newChatConversation(idSender, Integer.parseInt(params.get("to")));
		return "";
	}
	
	
	public String makeChats(){
		String tmp;
		String msgTmp;
		String msgsTmp ="";
		String result ="";
		String modelChat = 
				"<div class='box box-primary direct-chat direct-chat-primary'>"+
						"<div class='box-header with-border'>"+
							"<h3 class='box-title'>%userName%</h3>"+
							"<div class='box-tools pull-right'>"+
								"<button class='btn btn-box-tool' data-widget='collapse'><i class='fa fa-minus'></i></button>"+
								"<button class='btn btn-box-tool' data-widget='remove'><i class='fa fa-times'></i></button>"+
							"</div>"+
						"</div><!-- /.box-header -->"+
						"<div class='box-body'>"+
							"<!-- Conversations are loaded here -->"+
							"<div class='direct-chat-messages' id='contentMessages%idReceiver%'>"+							
								"%messages%"+
						"<div class='box-footer'>"+
							"<form action='#' method='post'>"+
								"<div class='input-group'>"+
									
									"<input type='text' name='message' id='msg%idReceiver%' class='form-control' placeholder='Message...'/>"+
									"<span class='input-group-btn'>"+
										"<input type='button' name='send' onclick='sendMessageTo(%idReceiver%,%idChat%)' id='search-btn' value='Send' />"+
									"</span>"+
									
								"</div>"+
							"</form>"+
						"</div><!-- /.box-footer-->"+
					"</div><!--/.direct-chat -->";
		
		String modelMessages =
				"<!-- Message. Default to the left or right -->"+
						"<div class='direct-chat-msg %position%'>"+
							"<div class='direct-chat-info clearfix'>"+
							"</div><!-- /.direct-chat-info -->"+
							"<img class='direct-chat-img' src='../dist/img/img-%position%-chat.png'/><!-- /.direct-chat-img -->"+
							"<div class='direct-chat-text'>"+
								"%message%"+
							"</div><!-- /.direct-chat-text -->"+
						"</div><!-- /.direct-chat-msg -->";
		
		for(Chat chat: chats){
			msgsTmp = "";
			int idReceiver;
			if(idSender == chat.getId_sender()){
				tmp = modelChat.replace("%userName%", chat.getNameUserFrom());
				idReceiver = chat.getId_receiver();
			}
			else{
				tmp = modelChat.replace("%userName%", chat.getNameUserSender());
				idReceiver = chat.getId_sender();
			}
			
			//Gera mensagens
			for(Message message: chat.getMessages()){
				msgTmp = modelMessages;
				if(idSender == message.getSender())
					msgTmp = msgTmp.replaceAll("%position%", "right");
				else
					msgTmp = msgTmp.replaceAll("%position%", "");
				
				msgTmp = msgTmp.replace("%message%", message.getMessage() == null?"":message.getMessage());
				msgsTmp += msgTmp;
			}
			
			tmp = tmp.replace("%messages%", msgsTmp);
			tmp = tmp.replace("%idChat%", String.format("%d",chat.getIdChat()));
			tmp = tmp.replaceAll("%idReceiver%", String.format("%s",idReceiver));
			
			result += tmp;
		}
		
		return result;
	}
	
	
	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}
	
}
