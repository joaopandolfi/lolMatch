package model;

/**
 * Created by batman on 24/05/2016.
 */
public class Match {
    private long idSender;
    private long idReceiver;
    private String date;
    private boolean verifyed;

    public Match(){

    }

    public long getIdSender() {
        return idSender;
    }

    public void setIdSender(long idSender) {
        this.idSender = idSender;
    }

    public long getIdReceiver() {
        return idReceiver;
    }

    public void setVerifyed(){
        verifyed = true;
    }

    public boolean isVerifyed(){
        return verifyed;
    }

    public void setIdReceiver(long idReceiver) {
        this.idReceiver = idReceiver;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
