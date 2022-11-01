package lotto.domain;

public class WinningLottoTicket extends LottoTicket {
	private WinningLottoTicket(LottoNumbers lottoNumbers) {
		super(lottoNumbers);
	}

	public static WinningLottoTicket from(LottoNumbers lottoNumbers) {
		return new WinningLottoTicket(lottoNumbers);
	}

	public int matchCount(LottoTicket lottoTicket) {
		LottoNumbers winningNumbers = super.lottonumbers();
		return winningNumbers.matchCount(lottoTicket.lottonumbers());
	}

}
