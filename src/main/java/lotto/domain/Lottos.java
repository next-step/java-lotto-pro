package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int size() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
