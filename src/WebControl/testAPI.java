package WebControl;

import riot.LolAPI;
import riot.LolQuery;
import riot.QueryMaker;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "testAPI", urlPatterns = {"/test"})
public class testAPI extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter page = resp.getWriter();

        LolAPI api = LolAPI.getInstance("b4547df0-8c17-440f-9d0f-1478ad410680");
        QueryMaker maker = new QueryMaker();
        // LolQuery query = maker.getSummonerById("1763066");

        String game_name = "Kiwi Boladis";
        LolQuery query = maker.getSummonersByName(game_name);

        try {

            JSONObject response = new JSONObject(api.query(query));
            JSONObject temp = response.getJSONObject(game_name.toLowerCase().replaceAll(" ",""));
            long id = temp.getLong("id");

            page.println(response);

            query = maker.getPlayerStatusById(Long.toString(id));
            JSONObject result_2 = new JSONObject(api.query(query));

            page.println();
            page.println(result_2);

        } catch (JSONException json_e) {
            json_e.printStackTrace();
        }

        //JSONObject result = new JSONObject(json_str);
        // page.println(api.query(query));
        // page.println(result);
        // query = maker.getPlayerStatusById("1763066");

        // JSONObject result = new JSONObject(api.query(query));
        // page.println(result.);
    }
}
