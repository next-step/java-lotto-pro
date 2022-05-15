package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lotto {
	public static final int LOTTO_SIZE = 6;
	private static final String INVALID_SIZE = "로또 번호는 6개를 입력해야 합니다.";
	private static final String INVALID_NUMBER = "숫자가 아닌 값이 있습니다.";
	private static final Pattern pattern = Pattern.compile("^-?[0-9]*$");

	private Numbers numbers;

	public Lotto(List<Number> numbers) {
		validSize(numbers);
		this.numbers = new Numbers(numbers);
	}

	public static Lotto getInstanceByString(List<String> strNumbers) {
		validSize(strNumbers);
		List<Number> numbers = new ArrayList<>();

		for(String number: strNumbers) {
			validNumber(number);
			numbers.add(new Number(Integer.parseInt(number)));
		}

		return new Lotto(numbers);
	}

	public Rank match(Lotto winningLotto) {
		int matchCount = numbers.match(winningLotto.numbers);

		return Rank.matchPrize(matchCount);
	}

	private static void validNumber(String number) {
		Matcher matcher = pattern.matcher(number);

		if(!matcher.find()) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}
	}

	private static void validSize(List numbers) {
		if(numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(INVALID_SIZE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return numbers.equals(lotto.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numbers);
	}
}
