package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
	private final List<Lotto> lottos = new ArrayList<>();

	public Lottos(List<List<Integer>> nestedLottoNumbers) {
		for (List<Integer> nestedLottoNumber : nestedLottoNumbers) {
			Lotto lotto = new Lotto(nestedLottoNumber);
			lottos.add(lotto);
		}
	}

	public RewardCalculator calcReward(Lotto winningLotto, LottoNumber bonusNumber) {
		RewardCalculator rewardCalculator = new RewardCalculator();
		for (Lotto lotto : lottos) {
			Rank lottoRank = lotto.calcLottoResult(winningLotto, bonusNumber);
			addResultCountWhenRankIsNotNone(lottoRank, rewardCalculator);
		}
		return rewardCalculator;
	}

	private void addResultCountWhenRankIsNotNone(Rank lottoRank, RewardCalculator rewardCalculator) {
		rewardCalculator.addCount(lottoRank);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lottos lottos1 = (Lottos)o;
		return Objects.equals(lottos, lottos1.lottos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottos);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Lotto lotto : lottos) {
			sb.append(lotto.toString());
			sb.append("\n");
		}
		return sb.toString().trim();
	}
}
