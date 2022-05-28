package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.RandomUtils;

public class Lottos {

    final List<Lotto> lottoSheets;

    public Lottos(List<Lotto> lottoSheets) {
        this.lottoSheets = lottoSheets;
    }

    public Lottos(int paperCount) {
        lottoSheets = new ArrayList<>();
        for (int i = 0; i < paperCount; i++) {
            lottoSheets.add(RandomUtils.createRandomLotto());
        }
    }

    public List<Lotto> getLottoSheets() {
        return lottoSheets;
    }

    public int getLottosSize() {
        return lottoSheets.size();
    }

    public void mergeLottos(Lottos targetLottos) {
        lottoSheets.addAll(targetLottos.getLottoSheets());
    }

}