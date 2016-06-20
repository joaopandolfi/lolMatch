package persistence;

import model.Chat;
import model.Message;

import java.util.ArrayList;

/**
 * Created by joao on 6/19/16.
 */
public class ChatDAO extends DAO{

    private ArrayList<Message> getMessagesBySql(String sql){
        ArrayList<Message> messages = new ArrayList<Message>();
        Message message;
        try {
            open();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                message = new Message();
                message.setId(rs.getInt("idmessage"));
                message.setMessage(rs.getString("message"));
                
                messages.add(message);
            }
            close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return messages;
    }

    /*
     * Cria chat entre dois usuarios Se nao existir
     * */
    public boolean createChat(int from, int to){
    	try {
            open();
            stmt = con.prepareStatement("SELECT * FROM chat WHERE (usuario_idusuario_sender = ? AND usuario_idusuario_receiver = ?) OR  (usuario_idusuario_sender = ? AND usuario_idusuario_receiver = ?)");
            stmt.setInt(1, from);
            stmt.setInt(2, to);
            stmt.setInt(3, to);
            stmt.setInt(4, from);
  
            stmt.executeQuery();
            while(rs.next()){
            	return false;
            }
            
            stmt = con.prepareStatement("INSERT INTO chat( usuario_idusuario_sender, usuario_idusuario_receiver) VALUES(?,?)");
            stmt.setInt(1, from);
            stmt.setInt(2, to);

            stmt.execute();
            close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    	
    }

    public boolean createChatNoValidation(int from, int to){
    	try {
            open();           
            stmt = con.prepareStatement("INSERT INTO chat( usuario_idusuario_sender, usuario_idusuario_receiver) VALUES(?,?)");
            stmt.setInt(1, from);
            stmt.setInt(2, to);

            stmt.execute();
            close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;    	
    }
    
    
    /*
     * Send message with Id Chat
     * */
    public boolean sendMessage(int idChat,Message message){
        try {
            open();
                      
            stmt = con.prepareStatement("INSERT INTO message(message, idchat) VALUES(?,?)");
            stmt.setString(1, message.getMessage());
            stmt.setInt(2, idChat);

            stmt.execute();
            close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    
    public ArrayList<Chat> getAllChats(int idUser){
        ArrayList<Chat> chats = new ArrayList<Chat>();
        Chat chat;
        try {
            open();
            stmt = con.prepareStatement("SELECT * FROM chat WHERE usuario_idusuario_sender = ? OR usuario_idusuario_receiver = ?");
            stmt.setInt(1, idUser);
            stmt.setInt(2, idUser);
            rs = stmt.executeQuery();

            while(rs.next()) {
                chat = new Chat();
                
                chat.setIdChat(rs.getInt("idmsg"));
                chat.setId_sender(rs.getInt("usuario_idusuario_sender"));
                chat.setId_receiver(rs.getInt("usuario_idusuario_receiver"));
                chats.add(chat);
            }
            close();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        //Getting messages
        for(Chat cChat: chats){
        	cChat.setMessages(getMessagesBySql("SELECT * FROM message where idmessage = "+cChat.getIdChat()));
        }
        
        return chats;

    }

    public void updateMessages(ArrayList<Message> messages){
        for(Message message: messages){

        }
    }
}
