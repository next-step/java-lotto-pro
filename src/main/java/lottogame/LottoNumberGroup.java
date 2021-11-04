package lottogame;

import java.util.List;

public class LottoNumberGroup {
	private List<LottoNumber> lottoNumbers;

	public LottoNumberGroup(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}
}
