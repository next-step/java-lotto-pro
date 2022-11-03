package lotto.model.vo;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public void print() {
        for (Lotto lotto : this.lottos) {
            lotto.print();
        }
    }
}
