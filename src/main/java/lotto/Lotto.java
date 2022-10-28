package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	private final static int SIZE_OF_LOTTO = 6;
	private final static int LOTTO_MIN_NUMBER = 1;
	private final static int LOTTO_MAX_NUMBER = 45;

	private final Set<Integer> numbers;

	public Lotto(final List<Integer> numbers) {
		this(new TreeSet<>(numbers));
	}

	public Lotto(final Set<Integer> numbers) {
		this.numbers = numbers;
		validate();
	}

	private void validate() {
		if (numbers.size() != SIZE_OF_LOTTO) {
			throw new IllegalArgumentException("로또의 번호는 6개 이다.");
		}
		for (final Integer number : numbers) {
			if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER){
				throw new IllegalArgumentException("로또의 숫자 범위는 1~45 이다.");
			}
		}
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
		return "Lotto{" +
			"numbers=" + numbers +
			'}';
	}
}
