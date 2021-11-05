package lottogame;

import java.util.List;

public class LottoTicket {

	private List<LottoNumber> lottoNumbers;

	public LottoTicket(List<LottoNumber> lottoNumber) {
		this.lottoNumbers = lottoNumber;
	}

	public LottoTicket() {
		this(LottoNumbersMaker.makelottoNumbers());
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public int getNumOfNumbersInGroup() {
		return lottoNumbers.size();
	}
}
