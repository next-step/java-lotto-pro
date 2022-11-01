package study.step3.models;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> rankLottos(Numbers winLottoNumbers) {
        for (Lotto lotto : lottos) {
            lotto.rank(winLottoNumbers);
        }
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void printAll() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public boolean hasEqualSize(int expected) {
        return lottos.size() == expected;
    }
}
