package lottogame;

import java.util.List;

public class LottoTicket {

	private List<LottoNumber> lottoNumbers;

	private LottoTicket(List<LottoNumber> lottoNumber) {
		this.lottoNumbers = lottoNumber;
	}

	public static LottoTicket makeLottoTicket() {
		return new LottoTicket(LottoNumbersMaker.makelottoNumbers());
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public int getNumOfNumbersInGroup() {
		return lottoNumbers.size();
	}
}
