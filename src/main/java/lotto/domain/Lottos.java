package lotto.domain;

import java.util.*;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public int getCount() {
        return lottoList.size();
    }

    public List<Rank> matchLottoStatic(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : this.lottoList) {
            ranks.add(Rank.valueOf(winningLotto.match(lotto), winningLotto.isContainsBonus(lotto)));
        }
        return ranks;
    }

    public LottoScore getLottoScore(WinningLotto winningLotto) {
        Map<Rank, Integer> map = new HashMap<>();
        List<Rank> ranks = matchLottoStatic(winningLotto);
        ranks.stream()
                .forEach(lottoStatistic -> map.put(lottoStatistic, map.getOrDefault(lottoStatistic, 1)));
        return new LottoScore(map);
    }
}
