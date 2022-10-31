package lotto.model;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	public final static Money LOTTO_PRICE = new Money(1000L);
	private final static int SIZE_OF_LOTTO = 6;

	private final Set<LottoNumber> numbers;

	public Lotto(final Collection<LottoNumber> numbers) {
		this.numbers = new TreeSet<>(numbers);
		validate();
	}

	private void validate() {
		if (numbers.size() != SIZE_OF_LOTTO) {
			throw new IllegalArgumentException("로또의 번호는 6개 이다.");
		}
	}

	public int match(final Lotto winnerLotto) {
		return (int)numbers.stream()
			.filter(winnerLotto::contain)
			.count();
	}

	public boolean matchBonus(final LottoNumber number) {
		return numbers.contains(number);
	}

	private boolean contain(final LottoNumber number) {
		return numbers.contains(number);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Lotto lotto = (Lotto)o;
		return Objects.equals(numbers, lotto.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
