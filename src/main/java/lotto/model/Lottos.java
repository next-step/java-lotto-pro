package lotto.model;

import java.util.List;

public class Lottos {
    private List<LottoNumbers> lottos;

    private Lottos(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<LottoNumbers> lottos) {
        return new Lottos(lottos);
    }
}
