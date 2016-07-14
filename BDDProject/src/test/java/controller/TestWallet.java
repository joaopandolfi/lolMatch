package controller;

import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Wallet;

/**
 * Created by joao on 7/5/16.
 */
public class TestWallet {
    Wallet wallet;

    @Given("^eu tenho (\\d+) na carteira$")
    public void euTenho(int valor){
        wallet = new Wallet();
        wallet.setSaldo(valor);
    }

    @When("^retiro (\\d+)$")
    public void retiro(int retiro){
        wallet.discountValue(retiro);
    }

    @When("^deposito (\\d+)$")
    public void deposito(int retiro){
        wallet.depositValue(retiro);
    }


    @Then("^fico com (\\d+)$")
    public void ficoCom(int ficoCom){
        assertEquals(ficoCom,wallet.getSaldo());
    }
}
