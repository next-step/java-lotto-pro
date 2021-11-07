package lottoservice.matcher;

import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottoticket.LottoTicket;
import lottoservice.lottoticket.LottoTickets;

public class LottoPrizeAnswer {

	private LottoWinningNumbers lottoWinningNumbers;
	private BonusNumber bonusNumber;

	private LottoPrizeAnswer(){
	}

	public LottoPrizeAnswer(LottoWinningNumbers lottoWinningNumbers, BonusNumber bonusNumber) {
		this.lottoWinningNumbers = lottoWinningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public boolean hasNumberInWinningNumbers(LottoNumber lottoNumber) {
		return lottoWinningNumbers.hasMatchNumber(lottoNumber);
	}

	public boolean isMatchBonusNumber(LottoNumber lottoNumber) {
		return bonusNumber.isMatchNumber(lottoNumber);
	}

	public LottoMatchResult matchTickets(LottoTickets lottoTickets) {
		LottoMatchResult lottoMatchResult = new LottoMatchResult();
		for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
			lottoMatchResult.addMatchCount(matchTicket(lottoTicket));
		}
		return lottoMatchResult;
	}

	public LottoMatchRank matchTicket(LottoTicket lottoTicket) {
		boolean matchBonus = bonusNumber.matchTicket(lottoTicket);
		int matchCount = lottoWinningNumbers.matchCountWinningAndTicket(lottoTicket);
		return LottoMatchRank.valueOf(matchCount,matchBonus);
	}
}
