package step3.model;

import java.util.ArrayList;
import java.util.List;

import static step3.constant.Constant.EACH_LOTTO_PRICE;

public class Lottos {
    public List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }
}
