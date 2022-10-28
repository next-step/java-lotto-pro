package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.util.LottoUtil;

public class Lotto {
    public static final int PRICE = 1000;
    private final List<LottoNumber> purchaseLottoList;

    public Lotto(int purchaseMoney) {
        //todo money 객체화
        validateMoney(purchaseMoney);
        int count = purchaseMoney / PRICE;
        this.purchaseLottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            purchaseLottoList.add(new LottoNumber(LottoUtil.generate()));
        }
    }

    public Lotto(List<LottoNumber> purchaseLottoList) {
        this.purchaseLottoList = purchaseLottoList;
    }

    public List<LottoNumber> getPurchaseLottoList() {
        return Collections.unmodifiableList(purchaseLottoList);
    }

    public LottoResult getResult(LottoNumber winningLotto) {
        LottoResult result = new LottoResult();
        for (LottoNumber lottoNumber : purchaseLottoList) {
            result.putPrize(lottoNumber.calculateWinPrize(winningLotto));
        }
        return result;
    }

    private void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또 1장 가격은 1000원입니다. 1000원 이상의 금액을 입력해주세요.");
        }
    }
}
