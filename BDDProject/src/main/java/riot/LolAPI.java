package riot;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class LolAPI {
    private final String API_KEY;
    private static LolAPI instance;

    private LolAPI(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public static LolAPI getInstance(String API_KEY){
        if(instance == null){
            inicializaInstacia(API_KEY);
        }
        return instance;
    }

    public String query(LolQuery consult) {
        String uri = consult.getUrl() + "?api_key=" + API_KEY;
        String out = "";

        try {
            System.out.println("\nCall APIurl: "+uri);
            URL url = new URL(uri);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String input;

            while ((input = br.readLine()) != null)
                out += input;

            br.close();

        } catch (MalformedURLException mfu_e) {
            //mfu_e.printStackTrace();
            out = "error_url";
        } catch (IOException io_e) {
            //io_e.printStackTrace();
            out = "error_io";
        }
        System.out.println("Response: "+out);
        return out;
    }
    //Devido a sincronia evita que seja criada varias instancias
    private static synchronized void inicializaInstacia(String API_KEY){
        if(instance == null){
            instance =  new LolAPI(API_KEY);
        }
    }
}
