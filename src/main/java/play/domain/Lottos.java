package play.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Lottos(int amount) {
        this.lottoList = generateLotto(amount);
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    private List<Lotto> generateLotto(int amount) {
        List lottoList = new ArrayList<Lotto>();

        for (int i = 0; i < amount; i++) {
            lottoList.add(Lotto.createAutoLotto());
        }

        return lottoList;
    }
}
