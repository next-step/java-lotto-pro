package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottos);
    }

    public void addManualLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public void genAutoLotto(int autoLottoCnt) {
        for (int i = 0; i < autoLottoCnt; i++) {
            lottos.add(new AutoLottoGenerator().genAutoLotto());
        }
    }
}
