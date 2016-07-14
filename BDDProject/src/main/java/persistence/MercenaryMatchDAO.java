package persistence;

import model.Match;
import model.MercenaryMatch;

/**
 * Created by Batman on 24/05/2016.
 */
public class MercenaryMatchDAO extends DAO {

    /*
    * Salva o match Mercenario : OBS: Não faz o pagamento
    * @params match {Match}
    * @returs boolean {boolean}
    * */
    public boolean save(MercenaryMatch mercenaryMatch){
        try {
            open();
            stmt = con.prepareStatement("INSERT INTO contratos(data, valor, usuario_idusuario_contratante,usuario_idusuario_contratado) VALUES(?,?,?,?)");
            stmt.setString(1, mercenaryMatch.getDate());
            stmt.setInt(2, mercenaryMatch.getPrice());
            stmt.setInt(3, (int) mercenaryMatch.getIdSender());
            stmt.setInt(3, (int) mercenaryMatch.getIdReceiver());
            stmt.execute();
            close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
