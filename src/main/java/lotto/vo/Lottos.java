package lotto.vo;

import java.util.ArrayList;
import java.util.List;

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
}
