package lotto.domain;

import java.util.*;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos() {
    }

    public void autoGenerator(int count) {
        List<Lotto> list = new ArrayList<>();
        for (int i=0; i<count; i++) {
            list.add(LottoFactory.autoGenerator());
        }
        this.lottoList = list;
    }

    public void manualGenerator(String[] input) {
        List<Lotto> list = new ArrayList<>();
        for (String s : input) {
            list.add(LottoFactory.manualGenerator(s));
        }
        this.lottoList = list;
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
