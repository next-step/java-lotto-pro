package step3.lotto;

import java.util.List;

import step3.winner.WinningResult;

public class LottoPapers {

	private final List<LottoNumbers> papers;

	private LottoPapers(List<LottoNumbers> lottoNumbers) {
		this.papers = lottoNumbers;
	}

	public static LottoPapers createPapers(List<LottoNumbers> lottoNumbers) {
		return new LottoPapers(lottoNumbers);
	}

	public WinningResult findMatchWinningResult(LottoNumbers userLottoNumbers, BonusBall bonusBall) {
		WinningResult matchResult = new WinningResult();
		for (LottoNumbers lottoNumbers : papers) {
			Integer matchCount = lottoNumbers.matchCount(userLottoNumbers);
			boolean hasBonusBall = lottoNumbers.hasBonusBall(bonusBall);
			matchResult.add(matchCount, hasBonusBall);
		}
		return matchResult;
	}

	public void addAll(LottoPapers autoLottoPapers) {
		this.papers.addAll(autoLottoPapers.papers);
	}

	public int size() {
		return papers.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (LottoNumbers paper : papers) {
			sb.append(paper).append("\n");
		}
		return sb.toString();
	}
}
