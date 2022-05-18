package lotto.domain;

import static lotto.domain.LottoPrice.LOTTO_PRICE;

public class LottoCount {
    private final int autoCount;
    private final int manualCount;

    public LottoCount(int manualCount, LottoPrice lottoPrice) {
        this.manualCount = manualCount;
        validate(lottoPrice);
        this.autoCount = initAutoCount(lottoPrice);
    }

    private void validate(LottoPrice lottoPrice) {
        if (manualCount < 0) {
            throw new IllegalArgumentException("수동구매수는 음수가 될 수 없습니다.");
        }
        if (manualCount * LOTTO_PRICE > lottoPrice.getPrice()) {
            throw new IllegalArgumentException("입력받은 구입금액으로는 수동로또를 구매할 금액이 부족합니다.");
        }
    }

    public Integer getManualCount() {
        return manualCount;
    }

    public Integer getAutoCount() {
        return autoCount;
    }

    private Integer initAutoCount(LottoPrice lottoPrice) {
        return Math.max(lottoPrice.getPrice() - manualCount * LOTTO_PRICE, 0) / LOTTO_PRICE;
    }

}
