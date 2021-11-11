package edu.lotto.model;

import java.util.List;

/**
 * LottoNumber Wrapping 객체
 * @since 2021.11.11
 * @author Inmook,Jeong
 */
public class LottoNumber {

	private int lottoNumber;

	private LottoNumber() {}

	public LottoNumber(int lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	/**
	 * 로또 번호 가져오기
	 * @return
	 */
	public int getLottoNumber() {
		return this.lottoNumber;
	}

	/**
	 * 로또 번호가 지난 주 정답에 포함되어 있는지 확인
	 * @param winningNumbers
	 * @return
	 */
	public boolean containLottoNumber(List<LottoNumber> winningNumbers) {
		long containCunt = winningNumbers.stream()
										.filter(lottoNumber -> lottoNumber.getLottoNumber() == this.lottoNumber)
										.count();
		return (containCunt != 0);
	}

	@Override
	public String toString() {
		return String.valueOf(this.lottoNumber);
	}
}
