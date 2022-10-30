package model;

import model.strategy.NumberStrategy;

import java.util.List;

import static common.Constants.ADD_WIN_NUMBER_COUNT;

public class Lottos {

    private final List<LottoNumber> lotto;

    public Lottos(Money money, NumberStrategy strategy) {
        int count = money.availableBuyLottoCount();
        this.lotto = new Seller().buy(count, strategy);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }
}
