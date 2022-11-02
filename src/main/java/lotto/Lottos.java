package lotto;

import java.util.ArrayList;
import java.util.List;

// 일급콜렉션
public class Lottos {
    List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
