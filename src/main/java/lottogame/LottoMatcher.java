package lottogame;

public class LottoMatcher {

	private LottoWinningNumbers lottoWinningNumbers;

	public LottoMatcher(LottoWinningNumbers lottoWinningNumbers){
		this.lottoWinningNumbers=lottoWinningNumbers;
	}

	public int matchCountWinningAndTicket(LottoTicket lottoTicket) {
		return lottoWinningNumbers.compareWithNumbers(lottoTicket.getLottoNumbers());
	}

	public LottoMatchResult matchWinningAndTickets(LottoTickets lottoTickets) {
		LottoMatchResult lottoMatchResult = new LottoMatchResult();
		for(LottoTicket lottoTicket : lottoTickets.getLottoTickets()){
			setMatchResult(lottoMatchResult,lottoTicket);
		}
		return lottoMatchResult;
	}

	private void setMatchResult(LottoMatchResult lottoMatchResult, LottoTicket lottoTicket) {
		int matchCount = matchCountWinningAndTicket(lottoTicket);
		if(hasMatch(matchCount)){
			lottoMatchResult.addCount(LottoMatchRank.valueOf(matchCount));
		}
	}

	private boolean hasMatch(int matchCount){
		if(matchCount>0){
			return true;
		}
		return false;
	}
}
