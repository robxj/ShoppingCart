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

	@Test
	public void testCheckoutSingleOrange() {
		BigDecimal cost = new Cart(new String[]{"orange"}).checkout();
		assertEquals("Wrong cost", BigDecimal.valueOf(25,2), cost);
	}

	@Test
	public void testCheckoutWhenEmptyCart() {
		BigDecimal cost = new Cart(new String[]{}).checkout();
		assertEquals("Wrong cost", BigDecimal.valueOf(0), cost);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCheckoutWhenUnknownItem() {
		BigDecimal cost = new Cart(new String[]{"pears"}).checkout();
	}

	@Test
	public void testCheckoutAppleAppleOrangeApple() {
		BigDecimal cost = new Cart(new String[]{"apple","apple","orange","apple"}).checkout();
		assertEquals("Wrong cost", BigDecimal.valueOf(205,2), cost);
	}

	
}
