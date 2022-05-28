package UnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Player;
import model.PlayerRoster;

public class PlayerRosterTest {
	private PlayerRoster pr;
	
	@BeforeEach
	public void setUp() { 
		pr = new PlayerRoster();
	}
	
	@Test
	public void FindPlayerTest() { 
		Player p = new Player("Giorgos",null);
		pr.addPls(p);
		assertEquals(p , pr.findPlayer("Giorgos"));	
	}
	
}
