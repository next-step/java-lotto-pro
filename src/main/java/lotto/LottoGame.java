/*
 * LottoGame.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final int money;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoGame(int money, LottoNumberGenerator lottoNumberGenerator) {
        this.money = money;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int getPurchaseCount() {
        return money / LOTTO_PRICE;
    }

    public List<LottoNumbers> purchaseLotto(int purchaseCount) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoNumbers.add(LottoNumbers.from(lottoNumberGenerator.generateSixNumbers()));
        }
        return lottoNumbers;
    }
}
