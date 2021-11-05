import java.util.List;

public class WinningLotto extends Lotto {

	private final LottoNumber bonus;

	private WinningLotto(LottoNumber bonus, List<LottoNumber> lottoNumbers) {
		super(lottoNumbers);
		this.bonus = bonus;
	}

	public static WinningLotto from(String bonus, String lottoNumbers) {
		return new WinningLotto(LottoNumber.from(bonus), LottoParser.parse(lottoNumbers));
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
