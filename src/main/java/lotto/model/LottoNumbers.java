package lotto.model;

import java.util.Collections;
import java.util.List;

import lotto.LottoUtil;

public class LottoNumbers {	
	private List<LottoNumber> lottoNumbers;
	
	public LottoNumbers(List<LottoNumber> lottoNumbers) {
		validationEmpty(lottoNumbers);
		validationCount(lottoNumbers);
		Collections.sort(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}
	
	public List<LottoNumber> getLottoNumbers() {
		return this.lottoNumbers;
	}
	
	private void validationEmpty(List<LottoNumber> lottoNumbers) {
		if (isEmpty(lottoNumbers)) {
			throw new NullPointerException("Collection이 비어있습니다.");
		}
	}
	
	private boolean isEmpty(List<LottoNumber> lottoNumbers) {
		return lottoNumbers == null || lottoNumbers.isEmpty();
	}
	
	private void validationCount(List<LottoNumber> lottoNumbers) {
		if (!isLottoCount(lottoNumbers)) {
			throw new IllegalArgumentException("size:" + lottoNumbers.stream().distinct().count() + " LottoSize: " + LottoUtil.LOTTO_NUMBERS_COUNT);
		}
	}
	
	private boolean isLottoCount(List<LottoNumber> lottoNumbers) {
		return lottoNumbers
				.stream()
				.distinct()
				.count() == LottoUtil.LOTTO_NUMBERS_COUNT;
	}
}
