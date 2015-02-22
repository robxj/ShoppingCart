package robertjansen.hmrc.exercise.shoppingcart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String[] items;
	private Map<String,BigDecimal> prices = new HashMap<String, BigDecimal>();

	public Cart(String[] items) {
		this.items = items;
		
		prices.put("apple", BigDecimal.valueOf(60,2));
		prices.put("orange", BigDecimal.valueOf(25,2));
	}

	public BigDecimal checkout() {
		BigDecimal total = BigDecimal.valueOf(0);
		for (String itemToPrice: items) {
			if (!prices.containsKey(itemToPrice)) {
				throw new IllegalArgumentException("No price for \'"+itemToPrice+"\'");
			}
			total = total.add( prices.get(itemToPrice) );
		}
		return total;
	}

}
