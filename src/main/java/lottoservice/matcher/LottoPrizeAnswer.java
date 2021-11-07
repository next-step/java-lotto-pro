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
			// setMatchResult(lottoMatchResult, lottoTicket);
		}
		return lottoMatchResult;
	}

	// /* 인자로 넘어온 티켓들을 정답과 비교하여 결과를 리턴 */
	// public LottoMatchResult matchWinningAndTickets(LottoTickets lottoTickets) {
	//
	// 	for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
	// 		setMatchResult(lottoMatchResult, lottoTicket);
	// 	}
	// 	return lottoMatchResult;
	// }
	//
	// private void setMatchResult(LottoMatchResult lottoMatchResult, LottoTicket lottoTicket) {
	// 	int matchCount = matchCountWinningAndTicket(lottoTicket);
	// 	if (hasMatch(matchCount)) {
	// 		lottoMatchResult.addMatchCount(LottoMatchRank.valueOf(matchCount,false));
	// 	}
	// }

	public LottoMatchRank matchTicket(LottoTicket lottoTicket) {
		boolean matchBonus = bonusNumber.matchTicket(lottoTicket);
		int matchCount = lottoWinningNumbers.matchCountWinningAndTicket(lottoTicket);
		return LottoMatchRank.valueOf(matchCount,matchBonus);
	}
}
