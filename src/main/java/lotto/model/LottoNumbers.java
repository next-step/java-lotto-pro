package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	private List<Integer> numbers;

	public LottoNumbers() {
		numbers = new ArrayList<>();
		for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
			numbers.add(makeLottoNumber());
		}
	}

	/**
	 * 로또 번호 생성
	 * @return 최소값(1) ~ 최대값(45) 사이의 정수
	 */
	private int makeLottoNumber() {
		return (int)(Math.random() * MAX_LOTTO_NUMBER + MIN_LOTTO_NUMBER);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	public static void main(String[] args) {
		LottoNumbers n = new LottoNumbers();
		System.out.println(n.toString().replaceAll("[\\]\\[, ]",""));
	}
}
