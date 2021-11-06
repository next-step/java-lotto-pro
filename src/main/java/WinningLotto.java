import java.util.List;

public class WinningLotto extends Lotto {

	private final LottoNumber bonus;

	WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
		super(lottoNumbers);
		validate(bonus);
		this.bonus = bonus;
	}

	private void validate(LottoNumber bonus) {
		if (lottoNumbers.contains(bonus)) {
			throw new WinningLottoFormatException();
		}
	}

	public int countMatching(Lotto lotto) {
		return lotto.lottoNumbers.stream()
			.reduce(0, (acc, lottoNumber) -> acc + countIfContains(lottoNumber), Integer::sum);
	}

	private int countIfContains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber) ? 1 : 0;
	}

	public LottoNumber getBonus() {
		return bonus;
	}
}
