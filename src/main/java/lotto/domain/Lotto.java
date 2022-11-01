package lotto.domain;

import java.util.List;

public class Lotto {

    private List<Integer> lotto;

    public Lotto() {
        this.lotto = new AutoLottoGenerator().getShuffledNum();
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }

}
