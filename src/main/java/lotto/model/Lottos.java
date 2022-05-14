package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private static final int NOT_MATCHED = 0;

    private final int gameCount;
    private final List<Lotto> lottoList;
    private final Map<Integer, Integer> resultCountMap;
    private double resultProfitRate;

    public Lottos(int playCount) {
        this.gameCount = playCount;
        this.lottoList = new ArrayList<>();
        this.resultCountMap = new HashMap<>();
    }

    public Lottos(final List<Lotto> lottoList){
        this.lottoList = lottoList;
        this.gameCount = lottoList.size();
        this.resultCountMap = new HashMap<>();
    }

    public Lottos() {
        this.lottoList = new ArrayList<>();
        this.gameCount = lottoList.size();
        this.resultCountMap = new HashMap<>();
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public int getResultCount(int matchNumberCount) {
        return resultCountMap.getOrDefault(matchNumberCount, NOT_MATCHED);
    }

    public void updateResultCountMap(int matchNumberCount) {
        resultCountMap.put(matchNumberCount, resultCountMap.getOrDefault(matchNumberCount, 0) + 1);
    }

    public double getResultProfitRate() {
        return resultProfitRate;
    }

    public void setResultProfitRate(double resultProfitRate) {
        this.resultProfitRate = resultProfitRate;
    }

    public int lottoCount() {
        return lottoList.size();
    }
}
