package riot;

import java.net.URI;

public class LolQuery {
    private String prefix = "https://{region}.api.pvp.net";
    private String region;
    private String urlQuery;

    public LolQuery(String region, String urlQuery, String... paramethers){
        this.region = region;
        this.urlQuery = urlQuery;
        this.urlQuery = this.urlQuery.replace("{region}", region);
        this.prefix = this.prefix.replace("{region}", region);


        for (int i = 0; i < paramethers.length; i++)
            this.urlQuery = this.urlQuery.replaceFirst("\\{[a-zA-Z]+\\}", paramethers[i].replaceAll(" ","%20"));

    }

    public String getUrl() {
        return prefix+urlQuery;
    }
}
