package lotto.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final int playCount;
    private final List<Lotto> lottoList;

    public Lottos(int playCount) {
        this.playCount = playCount;
        this.lottoList = new ArrayList<>();
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

    public Map<Integer, Integer> getWiningCountMap() {
        return new HashMap<>();
    }
}
