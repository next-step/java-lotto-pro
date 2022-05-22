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

    public List<Rank> matchLottoStatic(Lotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : this.lottoList) {
            ranks.add(Rank.valueOf(winningLotto.match(lotto)));
        }
        return ranks;
    }

    public Map<Rank, Integer> matchLottoStaticToString(Lotto winningLotto) {
        Map<Rank, Integer> map = new HashMap<>();
        List<Rank> ranks = matchLottoStatic(winningLotto);
        ranks.stream()
                .forEach(lottoStatistic -> map.put(lottoStatistic, map.getOrDefault(lottoStatistic, 1)));
        return map;
    }
}
