package controller;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.runner.RunWith;

import constants.Config;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import model.User;
import riot.LolAPI;

public class testControllers {
	LoginControl loginControl;
	LolAPI lolApi;
	User user;

	 @Given("^meu login e \"(.*?)\" e minha senha e \"(.*?)\"$")
	    public void meuLoginESenha(String login, String senha) throws Throwable {
			 lolApi = LolAPI.getInstance(Config.LOL_API);
			 loginControl = new LoginControl(lolApi);
			 user = new User();
			user.setLogin(login);
			user.setPass(senha);
	    }

	    @When("^eu realizar \"(.*?)\"$")
	    public void euRealizarA(String arg1) throws Throwable {
	    	if(arg1.equals("logar"))
	    		loginControl.login(user);
	    }

	    @Then("^meu IdInGame vai ser \"(.*?)\"$")
	    public void euVouReceberOSeguinte(String idInGame) throws Throwable {
	    	assertEquals(idInGame,loginControl.getLoggedPlayer().getIdInGame());
	    }
}
