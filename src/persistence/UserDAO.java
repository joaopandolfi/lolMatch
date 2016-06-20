package persistence;

import model.Player;
import model.User;

/**
 * Created by joao on 6/9/16.
 */
public class UserDAO extends DAO {

    /*
    * Faz login e retorna os dados do usuario
    * @param user {User}
    * @returns loggedUser {User}
    * */
    public User login(User user){
        Player player;
        try {
            open();
            stmt = con.prepareStatement("SELECT u.nome, u.email, u.idusuario, l.idingame, l.avaliacao, l.idtitulo, l.idingame FROM usuario as u INNER JOIN lolaccount as l ON u.lolaccount_idlolaccount = l.idlolaccount WHERE email= '"+user.getLogin()+"' AND senha = '"+user
                    .getAndFlushPass()+"'");
            rs = stmt.executeQuery();

            while(rs.next()){
                player = new Player();
                user.setLogged();
                user.setId(rs.getString("idusuario"));
                user.setName(rs.getString("nome"));
                player.setName(rs.getString("idingame"));
                player.setAvaliation(rs.getDouble("avaliacao"));
                player.setIdTitle(rs.getInt("idtitulo"));
                player.setIdInGame(rs.getString("idingame"));
                player.setId(user.getId());
                user.setPlayer(player);
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /*
    * Salva o usuário com funcao de insercao
    * @param user {User}
    * @returns boolean {boolean}
    * */
    public boolean saveCascade(User user){
    	try {
            open();

            //TODO: TROCAR PARA FUNCAO DE INSERCAO
            stmt = con.prepareStatement("INSERT INTO user(nome, email, senha) VALUES(?,?,?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getAndFlushPass());
            stmt.execute();

            close();
        }catch (Exception e){
            return false;
        }
        return true;    	
    }
    
    /*
    * Salva o usuário
    * @param user {User}
    * @returns boolean {boolean}
    * */
    public boolean save(User user){
        try {
            open();

            stmt = con.prepareStatement("INSERT INTO user(nome, email, senha) VALUES(?,?,?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getAndFlushPass());
            stmt.execute();

            close();
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
