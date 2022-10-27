package lotto;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	private final static int SIZE_OF_LOTTO = 6;

	private final Set<Integer> numbers;

	public Lotto(final List<Integer> numbers) {
		this.numbers = new TreeSet<>(numbers);
		validate();
	}

	private void validate() {
		if (numbers.size() != SIZE_OF_LOTTO) {
			throw new IllegalArgumentException("로또의 번호는 6개 이다.");
		}
	}
}
