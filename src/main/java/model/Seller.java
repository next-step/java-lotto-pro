package model;

import model.strategy.NumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private final List<LottoNumber> lotto;

    public Seller() {
        this.lotto = new ArrayList<>();
    }

    public List<LottoNumber> buyAuto(int count, NumberStrategy strategy) {
        for (int i = 0; i < count; i++) {
            lotto.add(new LottoNumber(strategy.shuffle()));
        }

        return lotto;
    }

    public List<LottoNumber> buyManual(List<Integer> numbers) {
        lotto.add(new LottoNumber(numbers));

        return lotto;
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }
}
