package robertjansen.hmrc.exercise.shoppingcart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String[] items;
	private Map<String,BigDecimal> prices = new HashMap<String, BigDecimal>();
	private Map<String,Integer> multibuyFreeOne = new HashMap<String, Integer>();

	public Cart(String[] items) {
		this.items = items;
		
		prices.put("apple", BigDecimal.valueOf(60,2));
		multibuyFreeOne.put("apple", 2);
		
		prices.put("orange", BigDecimal.valueOf(25,2));
		multibuyFreeOne.put("orange", 3);
	}

	public BigDecimal checkout() {
		BigDecimal total = BigDecimal.valueOf(0);
		
		Map<String,Integer> itemNumbers = new HashMap<String, Integer>();
		
		for (String itemToCount: items) {
			itemNumbers.putIfAbsent(itemToCount, 0);
			itemNumbers.put(itemToCount, itemNumbers.get(itemToCount)+1);
		}
		
		for (String itemToPrice: itemNumbers.keySet()) {
			total = total.add( priceWithMultiBuyOffers(itemToPrice, itemNumbers.get(itemToPrice)) );
		}
		return total;
	}

	private BigDecimal priceWithMultiBuyOffers(String itemToPrice, Integer itemCount) {
		if (!prices.containsKey(itemToPrice)) {
			throw new IllegalArgumentException("No price for \'"+itemToPrice+"\'");
		}
		int numberFree = itemCount / multibuyFreeOne.get(itemToPrice);
		return prices.get(itemToPrice).multiply(BigDecimal.valueOf(itemCount - numberFree));
	}

}
