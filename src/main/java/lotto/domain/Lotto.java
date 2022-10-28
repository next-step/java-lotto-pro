package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.util.LottoGeneratorUtil;

public class Lotto {
    public static final int PRICE = 1000;
    private final List<LottoNumber> purchaseLottoList;
    private LottoNumber winningNumbers;

    public Lotto(int purchaseMoney) {
        validate(purchaseMoney);
        int count = purchaseMoney / PRICE;
        this.purchaseLottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            purchaseLottoList.add(new LottoNumber(LottoGeneratorUtil.generate()));
        }
    }

    private void validate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또 1장 가격은 1000원입니다. 1000원 이상의 금액을 입력해주세요.");
        }
    }

    public List<LottoNumber> getPurchaseLottoList() {
        return Collections.unmodifiableList(purchaseLottoList);
    }
}
