package extras;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by joao on 6/19/16.
 */
public class TimeAPL {

    /*
    * Retorna data atual formatada para o banco de dados
    * @returns date {String}
    * */
    public static String getCurrentDateToBD(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
