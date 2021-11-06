package model.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import model.common.Money;
import model.common.string.StringDelimiters;
import model.common.string.StringSeparator;
import model.common.string.StringsProvider;
import utility.Assert;

public final class Customer {

	private Money money;
	private Collection<StringsProvider> numbers;

	private Customer(Money money, Collection<StringsProvider> numbers) {
		Assert.notNull(money, "'money' must not be null");
		Assert.notNull(numbers, "'numbers' must not be null");
		this.money = money;
		this.numbers = numbers;
	}

	public static Customer of(Money initialMoney, Collection<String> manualNumbers, StringDelimiters delimiters) {
		Assert.notNull(manualNumbers, "'manualNumbers' must not be null");
		Assert.notNull(delimiters, "'delimiters' must not be null");
		return new Customer(initialMoney, stringsProviders(manualNumbers, delimiters));
	}

	private static Collection<StringsProvider> stringsProviders(
		Collection<String> numbers, StringDelimiters delimiters) {
		ArrayList<StringsProvider> providers = new ArrayList<>();
		for (String number : numbers) {
			providers.add(StringSeparator.of(number, delimiters));
		}
		return providers;
	}

	int purchaseCount(Money price) {
		return money.divide(price);
	}

	public Money money() {
		return money;
	}

	void subtractMoney(Money money) {
		if (hasLessThan(money)) {
			throw new IllegalStateException(
				String.format("too much subtract money(%s), not enough money(%s)", money, this.money));
		}
		this.money = this.money.subtract(money);
	}

	@Override
	public String toString() {
		return "Customer{" +
			"money=" + money +
			", numbers=" + numbers +
			'}';
	}

	public boolean hasNumbersGreaterThanPurchaseCount(Money price) {
		return purchaseCount(price) < numbers.size();
	}

	public int numberSize() {
		return numbers.size();
	}

	public Collection<StringsProvider> numbers() {
		return Collections.unmodifiableCollection(numbers);
	}

	private boolean hasLessThan(Money money) {
		return !this.money.moreThan(money);
	}
}
