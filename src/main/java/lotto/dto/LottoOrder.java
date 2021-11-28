package lotto.dto;

import java.util.Objects;

import lotto.domain.wrapper.LottoTicket;

public class LottoOrder {
	public static final int DEFAULT_CHANGES = 0;
	private static final String MESSAGE_WRONG_MIN_ORDER = "로또의 금액은 1,000원으로, 최소 1개 이상 구매하셔야합니다.";
	private static final String MESSAGE_WRONG_ORDER_TYPE = "올바르지 않는 구매 요청입니다.";
	private final int price;
	private final int count;
	private final int changes;

	private LottoOrder(int price, int count, int changes) {
		this.price = price;
		this.count = count;
		this.changes = changes;
	}

	public int getCount() {
		return this.count;
	}

	public int getChanges() {
		return this.changes;
	}

	public static LottoOrder byPrice(int orderPrice) {
		int count = orderPrice / LottoTicket.PRICE;
		int price = count * LottoTicket.PRICE;
		int changes = orderPrice - price;
		return new LottoOrder(price, count, changes);
	}

	public static LottoOrder byPrice(String orderPrice) {
		return byPrice(validateOrderPrice(orderPrice));
	}

	public static LottoOrder byOrderCount(int orderCount) {
		int price = orderCount * LottoTicket.PRICE;
		int changes = DEFAULT_CHANGES;
		return new LottoOrder(price, orderCount, changes);
	}

	public static LottoOrder byOrderCount(String orderCount) {
		return byOrderCount(validateOrderCount(orderCount));
	}

	private static int validateOrderPrice(String orderPrice) {
		try {
			int convertedPrice = Integer.parseInt(orderPrice);
			return validateOrderPrice(convertedPrice);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_WRONG_ORDER_TYPE);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(MESSAGE_WRONG_MIN_ORDER);
		}
	}

	private static int validateOrderPrice(int orderPrice) {
		if (orderPrice < LottoTicket.PRICE) {
			throw new IllegalArgumentException(MESSAGE_WRONG_MIN_ORDER);
		}
		return orderPrice;
	}

	public static int validateOrderCount(int orderCount) {
		if (orderCount < 1) {
			throw new IllegalArgumentException(MESSAGE_WRONG_MIN_ORDER);
		}
		return orderCount;
	}

	public static int validateOrderCount(String orderCount) {
		try {
			int convertedPrice = Integer.parseInt(orderCount);
			return validateOrderCount(convertedPrice);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_WRONG_ORDER_TYPE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LottoOrder))
			return false;
		LottoOrder that = (LottoOrder)o;
		return price == that.price &&
			count == that.count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, count);
	}
}
