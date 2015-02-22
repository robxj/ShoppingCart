package robertjansen.hmrc.exercise.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class CartTest {

	@Test
	public void testCheckoutSingleApple() {
		BigDecimal cost = new Cart(new String[]{"apple"}).checkout();
		assertEquals("Wrong cost", BigDecimal.valueOf(60,2), cost);
	}

}
