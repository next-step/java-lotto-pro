package lotto.domain;

import java.util.List;

public class Lottos {
    List<Lotto> lottoList;
    public Lottos(List<Lotto> lottos) {
        this.lottoList = lottos;
    }

    public int size() {
        return lottoList.size();
    }
}
