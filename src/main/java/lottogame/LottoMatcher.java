package lottogame;

public class LottoMatcher {

	private LottoMatcher(){
	}

	public static LottoMatcher setWinningNumbersAndTickets() {
		return new LottoMatcher();
	}

	public static int matchCountWinningAndTicket(LottoWinningNumbers lottoWinningNumbers, LottoTicket lottoTicket) {
		return lottoWinningNumbers.compareWithNumbers(lottoTicket.getLottoNumbers());
	}
}
