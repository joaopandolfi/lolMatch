package persistence;

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
                message.setId(rs.getInt("idmsg"));
                message.setMessage(rs.getString("message"));
                if(rs.getInt("read") == 1)
                    message.readed();

                messages.add(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return messages;
    }

    public boolean sendMessage(int from, int to,Message message){
        try {
            open();

            stmt = con.prepareStatement("INSERT INTO chat(message, usuario_idusuario_sender, usuario_idusuario_receiver) VALUES(?,?,?)");
            stmt.setString(1, message.getMessage());
            stmt.setInt(2, from);
            stmt.setInt(3, to);

            stmt.execute();
            close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public ArrayList<Message> getChats(int idReceiver){
        return getMessagesBySql("SELECT * FROM chat WHERE usuario_idusuario_receiver = "+idReceiver);
    }

    public void updateMessages(ArrayList<Message> messages){
        for(Message message: messages){

        }
    }
}
