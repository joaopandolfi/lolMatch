package persistence;

import model.Match;

/**
 * Created by batman on 24/05/2016.
 */
public class MatchDAO extends DAO {

    /*
    * Salva o match
    * @params match {Match}
    * @returs boolean {boolean}
    * */
    public boolean save(Match match){
        try {
            open();
            stmt = con.prepareStatement("INSERT INTO matchs(data, verifyed, usuario_idusuario_sender,usuario_idusuario_receiver) VALUES(?,?,?,?)");
            stmt.setString(1, match.getDate());
            stmt.setInt(2, match.isVerifyed()?1:0);
            stmt.setInt(3, (int) match.getIdSender());
            stmt.setInt(3, (int) match.getIdReceiver());
            stmt.execute();
            close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
