package TDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import constants.Config;
import controller.LoginControl;
import controller.WalletControl;
import controller.SearchControl;
import controller.ShopControl;
import model.Item;
import model.Player;
import model.User;
import model.Wallet;
import riot.LolAPI;

public class Tests {
	LoginControl loginControl;
	SearchControl searchControl;
	LolAPI lolApi;
	
	@Before
	public void setUp() throws Exception {
		lolApi = LolAPI.getInstance(Config.LOL_API);
		loginControl = new LoginControl(lolApi);
		searchControl = new SearchControl(lolApi);
	}

	@Test
	public void loginTest() {
		User user = new User();
		user.setLogin("t@1.com");
		user.setPass("123");
		assertEquals(true, loginControl.login(user));
	}
	
	@Test 
	public void checkAPI(){
		User user = new User();
		user.setLogin("t@1.com");
		user.setPass("123");
		loginControl.login(user);
		assertEquals("2320936",loginControl.getLoggedPlayer().getIdInGame());
	} 
	
	@Test
	public void testWallet(){
		Wallet wallet = new Wallet();
		wallet.setSaldo(200);
		WalletControl walletControl = new WalletControl(wallet);
		walletControl.discountValue(100);
		assertEquals(100, wallet.getSaldo());
	}

	@Test
	public void SearchControl(){
		Player player = searchControl.searchByName("seu madruga");
		assertEquals("404536",player.getIdInGame());
	}
	
	@Test
	public void ShopControl(){
		Wallet wallet = new Wallet();
		wallet.setSaldo(400);
		ShopControl shopControl = new ShopControl();
		Item item = new Item();
		item.setId(1);
		item.setValue(30);
		wallet = shopControl.buyItem(wallet, item, 1);
		assertEquals(370,wallet.getSaldo());
	}
	
}
