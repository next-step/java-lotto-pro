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

    public List<LottoStatistic> matchLottoStatic(Lotto winningLotto) {
        List<LottoStatistic> lottoStatistics = new ArrayList<>();
        for (Lotto lotto : this.lottoList) {
            lottoStatistics.add(LottoStatistic.valueOf(winningLotto.match(lotto)));
        }
        return lottoStatistics;
    }

    public Map<LottoStatistic, Integer> matchLottoStaticToString(Lotto winningLotto) {
        Map<LottoStatistic, Integer> map = new HashMap<>();
        List<LottoStatistic> lottoStatistics = matchLottoStatic(winningLotto);
        lottoStatistics.stream()
                .forEach(lottoStatistic -> map.put(lottoStatistic, map.getOrDefault(lottoStatistic, 1)));
        return map;
    }
}
