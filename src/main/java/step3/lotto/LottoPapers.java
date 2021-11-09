package step3.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import step3.winner.Rank;

public class LottoPapers {

	private final List<LottoNumbers> papers;

	private LottoPapers(List<LottoNumbers> lottoNumbers) {
		this.papers = lottoNumbers;
	}

	public static LottoPapers createPapers(List<LottoNumbers> lottoNumbers) {
		return new LottoPapers(lottoNumbers);
	}

	public List<Rank> findMatchLottoNumber(LottoNumbers userLottoNumbers, BonusBall bonusBall) {
		List<Rank> ranks = new ArrayList<>();
		for (LottoNumbers paper : papers) {
			Map<Integer, Boolean> match = paper.match(userLottoNumbers, bonusBall);
			createRanks(ranks, match);
		}
		return ranks;
	}

	private void createRanks(List<Rank> ranks, Map<Integer, Boolean> match) {
		for (Map.Entry<Integer,Boolean> matchNumber : match.entrySet()) {
			Rank rank = Rank.valueOf(matchNumber.getKey(), matchNumber.getValue());
			ranks.add(rank);
		}
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
