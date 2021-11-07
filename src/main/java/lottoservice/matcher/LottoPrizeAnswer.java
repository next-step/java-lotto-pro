package lottoservice.matcher;

import lottoservice.exception.DuplicateBonusNumberAndWinningNumbers;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottoticket.LottoTicket;
import lottoservice.lottoticket.LottoTickets;

public class LottoPrizeAnswer {

	private static final String ERROR_MESSAGE_DUPLICATE_WINNINGNUMBER_AND_BONUSNUMBER = "당첨번호와 보너스 번호는 중복될 수 없습니다.";
	private LottoWinningNumbers lottoWinningNumbers;
	private BonusNumber bonusNumber;

	private LottoPrizeAnswer() {
	}

	public LottoPrizeAnswer(LottoWinningNumbers lottoWinningNumbers, BonusNumber bonusNumber) {
		validateNotHasDuplicateNumbers(lottoWinningNumbers, bonusNumber);
		this.lottoWinningNumbers = lottoWinningNumbers;
		this.bonusNumber = bonusNumber;
	}

	private void validateNotHasDuplicateNumbers(LottoWinningNumbers lottoWinningNumbers, BonusNumber bonusNumber) {
		if (lottoWinningNumbers.hasMatchNumber(bonusNumber.getLottoNumber())) {
			throw new DuplicateBonusNumberAndWinningNumbers("당첨번호와 보너스 번호는 중복될 수 없습니다.");
		}
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
		return LottoMatchRank.valueOf(matchCount, matchBonus);
	}
}
