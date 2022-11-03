package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

public class WinningLottoTicket {

	private static final String INVALID_BONUS_NUMBER_MESSAGE = "보너스 번호는 당첨 번호와 중복 될 수 없습니다. 중복 번호 : ";
	private final LottoNumbers winningNumbers;
	private final LottoNumber bonusNumber;

	private WinningLottoTicket(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
		if (winningNumbers.contains(bonusNumber)) {
			throw new InvalidLottoNumberException(INVALID_BONUS_NUMBER_MESSAGE + bonusNumber);
		}
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLottoTicket from(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
		return new WinningLottoTicket(lottoNumbers, bonusNumber);
	}

	private int matchCount(LottoTicket lottoTicket) {
		return winningNumbers.matchCount(lottoTicket.lottonumbers());
	}

	public Rank rank(LottoTicket lottoTicket) {
		int matchCount = matchCount(lottoTicket);
		boolean matchBonus = lottoTicket.contains(bonusNumber);
		return Rank.of(matchCount, matchBonus);
	}

}
