package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public Lottos(int lottoCnt) {
        this.lottos = generateLottos(lottoCnt);
    }

    private List<Lotto> generateLottos(int lottoCnt) {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public int getLottosSize() {
        return this.lottos.size();
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottos);
    }
}
