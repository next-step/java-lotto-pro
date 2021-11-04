package lottogame;

public class LottoTicket {

	private LottoNumberGroup lottoNumberGroup;

	private LottoTicket(LottoNumberGroup lottoNumber) {
		this.lottoNumberGroup = lottoNumber;
	}

	public static LottoTicket makeLottoTicket() {
		return new LottoTicket(LottoNumbersMaker.makelottoNumbers());
	}

	public LottoNumberGroup getLottoNumberGroup() {
		return lottoNumberGroup;
	}

	public int numOfNumbersInGroup() {
		return lottoNumberGroup.getLottoNumbers().size();
	}
}
