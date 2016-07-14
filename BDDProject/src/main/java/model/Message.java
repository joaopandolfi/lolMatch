package model;

/**
 * Created by joao on 6/10/16.
 */
public class Message {
    private int id;
    private boolean read;
    private String message;
    private int sender;

    public Message(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRead() {
        return read;
    }

    public void readed() {
        this.read = true;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}
    
    
}
