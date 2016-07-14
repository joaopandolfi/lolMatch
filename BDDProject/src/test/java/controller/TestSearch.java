package controller;

import constants.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Player;
import model.User;
import riot.LolAPI;

import static org.junit.Assert.assertEquals;

/**
 * Created by joao on 7/5/16.
 */
public class TestSearch {
    LolAPI lolAPI;
    SearchControl searchControl;
    Player player;
    String name;
    @Given("^escrevo o nome do usuario \"(.*?)\"$")
    public void meuLoginESenha(String name) throws Throwable {
        lolAPI = LolAPI.getInstance(Config.LOL_API);
        searchControl = new SearchControl(lolAPI);
        this.name = name;
    }

    @When("^clico em \"(.*?)\"$")
    public void euRealizarA(String arg1) throws Throwable {
        if(arg1.equals("pesquisar"))
            player = searchControl.searchByName(name);
    }

    @Then("^o IdInGame vai ser \"(.*?)\"$")
    public void euVouReceberOSeguinte(String idInGame) throws Throwable {
        assertEquals(idInGame,player.getIdInGame());
    }
}
