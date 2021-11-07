package lottoservice.matcher;

import lottoservice.exception.DuplicateBonusNumberAndWinningNumbers;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottoticket.LottoTicket;
import lottoservice.lottoticket.LottoTickets;

public class LottoPrizeAnswer {

	private static final String ERROR_MESSAGE_DUPLICATE_WINNINGNUMBER_AND_BONUSNUMBER = "당첨번호와 보너스 번호는 중복될 수 없습니다.";
	private WinningNumbers winningNumbers;
	private BonusNumber bonusNumber;

	private LottoPrizeAnswer() {
	}

	public LottoPrizeAnswer(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
		validateNotHasDuplicateNumbers(winningNumbers, bonusNumber);
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	private void validateNotHasDuplicateNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
		if (winningNumbers.hasMatchNumber(bonusNumber.getLottoNumber())) {
			throw new DuplicateBonusNumberAndWinningNumbers(ERROR_MESSAGE_DUPLICATE_WINNINGNUMBER_AND_BONUSNUMBER);
		}
	}

	public boolean hasNumberInWinningNumbers(LottoNumber lottoNumber) {
		return winningNumbers.hasMatchNumber(lottoNumber);
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
		int matchCount = winningNumbers.matchCountWinningAndTicket(lottoTicket);
		return LottoMatchRank.valueOf(matchCount, matchBonus);
	}
}
