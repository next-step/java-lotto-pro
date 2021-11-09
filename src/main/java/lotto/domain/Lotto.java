package lotto.domain;

import java.util.List;

public class Lotto {
	private final LottoNumbers lottoNumbers;
	private Rank winningRank;

	public Lotto(final int... lottoNumbers) {
		this(new LottoNumbers(lottoNumbers));
	}

	public Lotto(final String lottoNumbers) {
		this(new LottoNumbers(lottoNumbers));
	}

	public Lotto(final LottoNumbers lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
		this.winningRank = Rank.MISS;
	}

	public void recordeRank(LottoNumbers winningNumbers, LottoNumber bonusBallNumber) {
		int count = countMatchedNumber(winningNumbers);
		for (Rank rank : Rank.values()) {
			confirmRank(count, rank);
		}
		confirmRankThirdOrSecond(count, isMatch(bonusBallNumber));
	}

	private void confirmRankThirdOrSecond(int count, boolean bonusCheck) {
		if (Rank.THIRD.getCountOfMatch() == count && !bonusCheck) {
			this.winningRank = Rank.THIRD;
		}
	}

	private int countMatchedNumber(LottoNumbers winningNumbers) {
		int count = 0;
		for (LottoNumber lottoNumber : winningNumbers.getLottoNumbers()) {
			count += this.lottoNumbers.ifMatchCount(lottoNumber);
		}
		return count;
	}

	private void confirmRank(int count, Rank rank) {
		if (rank.getCountOfMatch() == count) {
			this.winningRank = rank;
		}
	}

	private boolean isMatch(LottoNumber bonusBallNumber) {
		return this.lottoNumbers.ifMatchCount(bonusBallNumber) == LottoNumbers.MATCHED_NUMBER;
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers.getLottoNumbers();
	}

	public Rank getWinningRank() {
		return winningRank;
	}
}
