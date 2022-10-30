package model;

import model.strategy.NumberStrategy;

import java.util.ArrayList;
import java.util.List;

import static common.Constants.LOTTO_PRICE;

public class Lotto {

    private final int count;
    private final NumberStrategy strategy;
    private final List<LottoNumber> pickLottoNumber;

    public Lotto(int money, NumberStrategy strategy) {
        pickLottoNumber = new ArrayList<>();
        checkValidMoney(money);
        this.count = (money / LOTTO_PRICE);
        this.strategy = strategy;
    }

    public List<LottoNumber> buy() {
        for (int i = 0; i < count; i++) {
            LottoNumber lottoNumber = new LottoNumber(strategy);
            pickLottoNumber.add(lottoNumber);
        }

        return pickLottoNumber;
    }

    private void checkValidMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요.");
        }
    }
}
