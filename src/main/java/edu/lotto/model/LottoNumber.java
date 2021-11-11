package edu.lotto.model;

/**
 * LottoNumber Wrapping 객체
 * @since 2021.11.11
 * @author Inmook,Jeong
 */
public class LottoNumber {

	private int lottoNumber;

	public LottoNumber(int lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public int getLottoNumber() {
		return this.lottoNumber;
	}

	@Override
	public String toString() {
		return String.valueOf(this.lottoNumber);
	}
}
