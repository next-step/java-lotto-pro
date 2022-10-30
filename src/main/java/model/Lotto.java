package model;

import model.strategy.NumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lotto;

    public Lotto(int count, NumberStrategy strategy) {
        lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(new LottoNumber(strategy.shuffle()));
        }
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }
}
