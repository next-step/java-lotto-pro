package lotto.model;

import lotto.LottoUtil;
import util.NumberUtil;

public class LottoNumber implements Comparable<LottoNumber> {
	private int lottoNumber;

	public LottoNumber(String lottoNumber) {
		lottoNumber = lottoNumber.trim();
		validationNumber(lottoNumber);
		validationRange(Integer.parseInt(lottoNumber));
		this.lottoNumber = Integer.parseInt(lottoNumber);
	}

	public LottoNumber(int lottoNumber) {
		validationRange(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	public int getLottoNumber() {
		return this.lottoNumber;
	}

	private void validationRange(int lottoNumber) {
		if (!isRange(lottoNumber)) {
			throw new IllegalArgumentException(String.format("nubmer: %d %d~%d 범의의 숫자만 입력이 가능합니다.", lottoNumber,
					LottoUtil.MIN_LOTTO_NUMBER, LottoUtil.MAX_LOTTO_NUMBER));
		}
	}

	private boolean isRange(int lottoNumber) {
		return lottoNumber >= LottoUtil.MIN_LOTTO_NUMBER && lottoNumber <= LottoUtil.MAX_LOTTO_NUMBER;
	}

	private void validationNumber(String lottoNumber) {
		if (!NumberUtil.isNumber(lottoNumber)) {
			throw new IllegalArgumentException(String.format("nubmer: %d 숫자가 아닙니다.", lottoNumber));
		}
	}

	@Override
	public int compareTo(LottoNumber lottoNumber) {
		return getLottoNumber() - lottoNumber.getLottoNumber();
	}

	@Override
	public int hashCode() {
		return lottoNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof LottoNumber) {
			LottoNumber lottoNumber = (LottoNumber) o;
			return getLottoNumber() == lottoNumber.getLottoNumber();
		}
		if (o instanceof Integer) {
			return o.equals(getLottoNumber());
		}
		return false;
	}
}
