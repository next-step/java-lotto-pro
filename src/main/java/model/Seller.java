package model;

public final class Seller {

	private final Money price;
	private final LottoGenerator generator;

	private Seller(Money price, LottoGenerator generator) {
		validate(price);
		validate(generator);
		this.price = price;
		this.generator = generator;
	}

	public static Seller of(Money price, LottoGenerator generator) {
		return new Seller(price, generator);
	}

	public Money price() {
		return price;
	}

	public Lotto lotto() {
		return generator.lotto();
	}

	@Override
	public String toString() {
		return "Seller{" +
			"price=" + price +
			", generator=" + generator +
			'}';
	}

	private void validate(LottoGenerator generator) {
		if (generator == null) {
			throw new IllegalArgumentException("'generator' must not be null");
		}
	}

	private void validate(Money price) {
		if (price == null) {
			throw new IllegalArgumentException("'price' must not be null");
		}
	}
}
