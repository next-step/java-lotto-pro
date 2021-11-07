package model;

import java.util.Objects;

import model.common.LottoNumbers;
import utility.Assert;

public final class LottoPaper implements Lotto {

	private final LottoNumbers lottoNumbers;
	private final LottoType type;

	private LottoPaper(LottoNumbers lottoNumbers, LottoType type) {
		Assert.notNull(lottoNumbers, "'lottoNumbers' must not be null");
		Assert.notNull(type, "'type' must not be empty");
		this.lottoNumbers = lottoNumbers;
		this.type = type;
	}

	public static LottoPaper auto(LottoNumbers lottoNumbers) {
		return from(lottoNumbers, LottoType.AUTO);
	}

	public static LottoPaper manual(LottoNumbers lottoNumbers) {
		return from(lottoNumbers, LottoType.MANUAL);
	}

	private static LottoPaper from(LottoNumbers lottoNumbers, LottoType type) {
		return new LottoPaper(lottoNumbers, type);
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}

	public LottoRank rank(WinnerLotto winnerLotto) {
		return LottoRank.byMatchCountAndBonus(
			lottoNumbers.containsCount(winnerLotto.numbers()), lottoNumbers.contains(winnerLotto.bonus()));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoPaper that = (LottoPaper)o;
		return Objects.equals(lottoNumbers, that.lottoNumbers) && type == that.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers, type);
	}

	boolean isAuto() {
		return this.type.isAuto();
	}

	boolean isManual() {
		return this.type.isManual();
	}
}
