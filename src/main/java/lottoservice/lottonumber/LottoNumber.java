package lottoservice.lottonumber;

import java.util.Objects;

import lottoservice.exception.InvalidLottoFormatException;

/**
 * 원시 타입을 포장한 로또 번호 클래스
 */
public class LottoNumber implements Comparable<LottoNumber> {

	private static String ERROR_MESSAGE_OUTBOUND_OF_LOTTO_NUMBER =
		"로또 번호는 " + LottoNumbersMaker.START_INCLUSIVE_NUMBER + "~" + LottoNumbersMaker.END_EXCLUSIVE_NUMBER
			+ "사이 숫자만 가능합니다.";
	private int number;

	public LottoNumber(int number) {
		validateNumberInLottoRule(number);
		this.number = number;
	}

	public void validateNumberInLottoRule(int number) {
		if (number < LottoNumbersMaker.START_INCLUSIVE_NUMBER || number > LottoNumbersMaker.END_EXCLUSIVE_NUMBER) {
			throw new InvalidLottoFormatException(ERROR_MESSAGE_OUTBOUND_OF_LOTTO_NUMBER);
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

	@Override
	public int compareTo(LottoNumber o) {
		return isBiggerThan(o) ? 1
			: isLessThan(o) ? -1
			: 0;
	}

	public boolean isBiggerThan(LottoNumber o){
		return getNumber() > o.getNumber();
	}

	public boolean isLessThan(LottoNumber o){
		return getNumber() < o.getNumber();
	}
}
