package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.PlHistory;

public class PlayerHistoryTest {
	private PlHistory ph,ph1;
	
	@BeforeEach
	public void setUp() { 
		ph = new PlHistory(5, 2, 2, 1);
		ph1 = new PlHistory(0,1,2,2);
	}
	
	@Test
	public void PlScoreTest () { 
		assertEquals(50, ph.PlScore());
	}
	
	@Test
	public void PlScoreTest1 () { 
		assertEquals(0, ph1.PlScore());
	}
}
