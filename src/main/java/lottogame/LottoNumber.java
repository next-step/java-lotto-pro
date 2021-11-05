package lottogame;

import java.util.Objects;

import lottogame.exception.InvalidLottoFormatException;

class LottoNumber {

	private int number;

	public LottoNumber(int number) {
		validateNumberInLottoRule(number);
		this.number = number;
	}

	public void validateNumberInLottoRule(int number) {
		if (number < LottoNumbersMaker.START_INCLUSIVE_NUMBER || number > LottoNumbersMaker.END_EXCLUSIVE_NUMBER) {
			throw new InvalidLottoFormatException(
				"로또 번호는 " + LottoNumbersMaker.START_INCLUSIVE_NUMBER + "~" + LottoNumbersMaker.END_EXCLUSIVE_NUMBER
					+ "사이 숫자만 가능합니다.");
		}
	}

	public int getNumber() {
		return number;
	}

	/*
	 * LottoNumber 타입을 Set 자료구조에 사용할 때, add, remove, contains 등의 함수에서
	 * 로또 번호가 같으면(number) 동일 값으로 인지하고 찾기 위해 equals와 hashCode를 오버라이딩
	 * */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return getNumber() == that.getNumber();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumber());
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
