package lotto.model;

import lotto.enums.Rank;

import java.util.*;

public class Lottos {
    private List<LottoNumbers> lottos;

    private Lottos(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<LottoNumbers> lottos) {
        return new Lottos(new ArrayList<>(lottos));
    }

    public RankCount rankCount(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        Map<Rank, Integer> rankCount = initRankCount();
        lottos.forEach(lottoNumbers -> {
            int matchCount = lottoNumbers.matchCount(winningNumbers);
            Rank rank = Rank.getRank(matchCount, lottoNumbers.hasBonusNumber(bonusNumber));
            rankCount.put(rank, rankCount.get(rank) + 1);
        });
        return RankCount.from(rankCount);
    }

    private Map<Rank, Integer> initRankCount() {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
        return rankCount;
    }

    public int lottosCount() {
        return lottos.size();
    }

    public Lottos union(Lottos addedLottos) {
        lottos.addAll(addedLottos.lottos);
        return Lottos.from(lottos);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lottoNumbers -> sb.append(lottoNumbers).append("\n"));
        return sb.toString();
    }
}
