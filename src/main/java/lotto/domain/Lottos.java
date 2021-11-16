package lotto.domain;

import lotto.consts.LottoNumberConst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Price price) {
        lottos = new ArrayList<>();
        for (int i = 0; i < price.getNumberOfLotto(); i++) {
            Collections.shuffle(LottoNumberConst.lottoNumbers);
            lottos.add(new Lotto(new ArrayList<>(LottoNumberConst.lottoNumbers.subList(0, LottoNumberConst.LOTTO_NUMBER_SIZE))));
        }
    }

    /**
     * Constructor for test
     */
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
