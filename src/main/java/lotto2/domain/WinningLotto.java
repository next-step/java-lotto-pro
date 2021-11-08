package lotto2.domain;

import java.util.List;

public class WinningLotto {

	private final LottoTicket lottoNumbers;
	private final LottoNumber bonusNumber;

	private WinningLotto(LottoTicket lottoNumbers, LottoNumber bonusNumber) {
		this.lottoNumbers = lottoNumbers;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLotto of(LottoTicket lottoNumbers, LottoNumber bonusNumber) {
		validate(lottoNumbers, bonusNumber);
		return new WinningLotto(lottoNumbers, bonusNumber);
	}

	public static void validate(LottoTicket lottoNumbers, LottoNumber bonusNumber) {
		if (lottoNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_DUPLICATE.value());
		}
	}

	public static WinningLotto of(List<Integer> winningNumbers, int bonusNumberInt) {
		LottoTicket lottoNumbers = LottoTicket.of(winningNumbers);
		LottoNumber bonusNumber = LottoNumber.of(bonusNumberInt);
		return WinningLotto.of(lottoNumbers, bonusNumber);
	}

	public Rank getMatchRank(LottoTicket lottoTicket) {
		int matchCnt = lottoTicket.getMatchCount(this.lottoNumbers);
		boolean isMatchBonus = lottoTicket.contains(this.bonusNumber);
		return Rank.valueOf(PositiveNumber.of(matchCnt), isMatchBonus);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		WinningLotto that = (WinningLotto)o;

		if (!lottoNumbers.equals(that.lottoNumbers))
			return false;
		return bonusNumber.equals(that.bonusNumber);
	}

	@Override
	public int hashCode() {
		int result = lottoNumbers.hashCode();
		result = 31 * result + bonusNumber.hashCode();
		return result;
	}

}
