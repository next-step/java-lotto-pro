package model;

import util.NumberUtil;

public class Number {
	private static final int MIN_NUMBER = 0;
	private int number;

	public Number(String number) {
		validation(number);
		this.number = Integer.parseInt(number);
	}

	public int getNumber() {
		return this.number;
	}

	private void validation(String number) {
		if (!NumberUtil.isNumber(number)) {
			throw new RuntimeException(String.format("nubmer: %d 숫자가 아닙니다.", number));
		}

		if (!isNatural(Integer.parseInt(number))) {
			throw new RuntimeException(
					String.format("nubmer: %d %d보다 작은 수가 입력되었습니다.", Integer.parseInt(number), MIN_NUMBER));
		}
	}

	private boolean isNatural(int number) {
		return number > MIN_NUMBER;
	}
}
