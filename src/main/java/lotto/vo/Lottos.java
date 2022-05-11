package lotto.vo;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final int playCount;

    public Lottos(int playCount) {
        this.playCount = playCount;
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<Lotto> getLottoList() {
        return Collections.emptyList();
    }
}
