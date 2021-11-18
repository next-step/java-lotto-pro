package model;

import java.util.Objects;

import exception.OutOfRangeException;

public class LottoPurchasePrice {
	public static final String MESSAGE_PRICE_MUST_BE_LARGER_THAN_999 = "PRICE_MUST_BE_LARGER_THAN_999";
	public static final int LOTTO_TICKET_PRICE = 1000;

	private final int price;

	public LottoPurchasePrice(int price) {
		if (price < LOTTO_TICKET_PRICE) {
			throw new OutOfRangeException(MESSAGE_PRICE_MUST_BE_LARGER_THAN_999);
		}

		this.price = price;
	}

	public int get() {
		return price;
	}

	public LottoPurchaseCount toPurchaseCount() {
		return new LottoPurchaseCount(this.price / LOTTO_TICKET_PRICE);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoPurchasePrice that = (LottoPurchasePrice)o;
		return price == that.price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price);
	}
}
