package lotto2.domain;

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

	public Rank getMatchRank(LottoTicket lottoTicket) {
		int matchCnt = 0;
		boolean isMatchBonus = lottoTicket.contains(this.bonusNumber);
		for (LottoNumber lottoNumber : this.lottoNumbers) {
			matchCnt += (lottoTicket.contains(lottoNumber)) ? 1 : 0;
		}
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
