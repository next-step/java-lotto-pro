package model;

import static java.util.stream.Collectors.*;

import java.util.Set;
import java.util.stream.Stream;

public class BonusBall {
	private LottoNumber number;

	private BonusBall(Integer number) {
		this.number = LottoNumber.of(number);
	}

	public static BonusBall from(String number) {
		return new BonusBall(Integer.parseInt(number));
	}

	public static BonusBall from(Integer number) {
		return new BonusBall(number);
	}

	public static boolean validate(String number) {
		boolean isMatch = number.matches(Regex.NUMBER);
		Set<Integer> numbers = Stream.of(number)
			.map(Integer::parseInt)
			.collect(toSet());

		return isMatch && Lotto.isValidLottoNumber(numbers);
	}

	public LottoNumber getNumber() {
		return number;
	}
}
