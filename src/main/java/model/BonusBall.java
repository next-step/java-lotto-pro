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
		if (!number.matches(Regex.NUMBER)) {
			return false;
		}

		return LottoNumber.isValidNumber(Integer.parseInt(number));
	}

	public LottoNumber getNumber() {
		return number;
	}
}
