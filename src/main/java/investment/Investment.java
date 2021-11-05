package investment;

import static common.Constants.*;

public class Investment {
	private Price price;

	public Investment(String input) {
		this.price = new Price(input);
	}

	public Price getPrice() {
		return price;
	}

	public Integer getPriceSize() {
		return price.size();
	}

	public Integer getCount() {
		return price.floorDiv(PER_PRICE);
	}

}
