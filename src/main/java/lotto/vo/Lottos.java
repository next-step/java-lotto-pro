package lotto.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private static final int NOT_MATCHED = 0;

    private final int playCount;
    private final List<Lotto> lottoList;
    private final Map<Integer,Integer> resultCountMap;

    public Lottos(int playCount) {
        this.playCount = playCount;
        this.lottoList = new ArrayList<>();
        this.resultCountMap = new HashMap<>();
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public int getResultCount(int matchNumberCount) {
        return resultCountMap.getOrDefault(matchNumberCount,NOT_MATCHED);
    }

    public void updateResultCountMap(int matchNumberCount) {
        resultCountMap.put(matchNumberCount,resultCountMap.getOrDefault(matchNumberCount,0)+1);
    }
}
