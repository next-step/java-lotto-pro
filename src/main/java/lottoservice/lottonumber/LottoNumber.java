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
	private final int number;
	private static final LottoNumber[] cachedLottoNumbers;

	static {
		/* 스태틱 블록에서 LottoNumber 배열을 생성하여 number에 해당되는 index에 LottoNumber 객체를 캐싱 */
		cachedLottoNumbers = new LottoNumber[LottoNumbersMaker.END_EXCLUSIVE_NUMBER + 1];    /*	편의를 위해 END_EXCLUSIVE_NUMBER +1개의 배열 생성 */
		for (int i = 1; i <= LottoNumbersMaker.END_EXCLUSIVE_NUMBER; i++) {
			cachedLottoNumbers[i] = new LottoNumber(i);
		}
	}

	public static LottoNumber valueOf(int number) {
		validateNumberInLottoRule(number);
		return cachedLottoNumbers[number];
	}

	public LottoNumber(final int number) {
		validateNumberInLottoRule(number);
		this.number = number;
	}

	private static void validateNumberInLottoRule(int number) {
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

	private boolean isBiggerThan(LottoNumber o) {
		return getNumber() > o.getNumber();
	}

	private boolean isLessThan(LottoNumber o) {
		return getNumber() < o.getNumber();
	}
}
