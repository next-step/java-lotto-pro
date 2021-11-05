package lottoservice.matcher;

import lottoservice.lottoticket.LottoTicket;
import lottoservice.lottoticket.LottoTickets;

/**
 * 로또 당첨번호와 티켓을 비교하여 매칭 결과를 제공하는 클래스
 */
public class LottoMatcher {

	private LottoWinningNumbers lottoWinningNumbers;

	/* 객체 생성시 로또 당첨번호를 전달*/
	public LottoMatcher(LottoWinningNumbers lottoWinningNumbers) {
		this.lottoWinningNumbers = lottoWinningNumbers;
	}

	private int matchCountWinningAndTicket(LottoTicket lottoTicket) {
		return lottoWinningNumbers.compareWithNumbers(lottoTicket.getLottoNumbers());
	}

	/* 당첨번호와 비교할 티켓정보 전달 */
	public LottoMatchResult matchWinningAndTickets(LottoTickets lottoTickets) {
		LottoMatchResult lottoMatchResult = new LottoMatchResult();
		for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
			setMatchResult(lottoMatchResult, lottoTicket);
		}
		return lottoMatchResult;
	}

	private void setMatchResult(LottoMatchResult lottoMatchResult, LottoTicket lottoTicket) {
		int matchCount = matchCountWinningAndTicket(lottoTicket);
		if (hasMatch(matchCount)) {
			lottoMatchResult.addMatchCount(LottoMatchRank.valueOf(matchCount));
		}
	}

	private boolean hasMatch(int matchCount) {
		if (matchCount > 0) {
			return true;
		}
		return false;
	}
}
