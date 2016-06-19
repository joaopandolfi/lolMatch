package riot;

import java.net.URLEncoder;

public class QueryMaker {
    // LolQuery current;
    public final static String CHAMPION_STATUS = "ranked";
    public final static String GENERAL_STATUS = "summary";
    protected String region="br";

    /*
    * Seta regiao para busca
    * "br" by default
    * @param region {String}
    * */
    public void setRegion(String region){
        this.region = region;
    }

    /*
    * Retorna herois habilitados da semana
    * NOTE: DESABIlITADA
    * */
    public LolQuery getFreeWeekChampions() {
        //current = new LolQuery("https://br.api.pvp.net/api/lol/br/v1.2/champion?freeToPlay=true&");
        return null;
    }

    /*
    * Recupera os dados de usuario por nome
    * @param nameArray {String array}
    * @returns LolQuery
    * */
    public LolQuery getSummonersByName(String... nameArray) {
        String names = "";
        for (String name : nameArray) names += name + ',';
        return new LolQuery("br", "/api/lol/{region}/v1.4/summoner/by-name/{summonerNames}", names);
    }

    /*
    * Recupera os dados de usuario por ID
    * @param idArray {String array}
    * @returns LolQuery
    * */
    public LolQuery getSummonersById(String... idArray) {
        String ids = "";
        for (String id : idArray) ids += id + ',';
        return new LolQuery("br", "/api/lol/{region}/v1.4/summoner/{summonerIds}", ids);
    }

    /*
    * Recupera status do player pelo Id
    * @param summonerId {String}
    * @returns LolQuery
    * */
    public LolQuery getPlayerStatusById (String summonerId) { return getPlayerStatusById(summonerId, GENERAL_STATUS); }

    /*
    * Recupera os dados do player pelo id podendo ser geral ou do campeao
    * @param summonerId {String}
    * @param option {String} [ranked,summary]
    * @returns LolQuery
    * */
    public LolQuery getPlayerStatusById (String summonerId, String option) {
        if (!option.equals(CHAMPION_STATUS) && !option.equals(GENERAL_STATUS))
            return null;

        return new LolQuery("br", "/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/" + option, summonerId);
    }

    /*
    * Recupera partidas jogadas pelo Id
    * @param summonerId {String}
    * @returns LolQuerys
    * */
    public LolQuery getPlayerMatches(String summonerId){
        return new LolQuery("br","/api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent",summonerId);
    }
}
