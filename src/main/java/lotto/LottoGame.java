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
    private final LottoNumberGenerator lottoNumberGenerator;
    private final int money;

    public LottoGame(int money, LottoNumberGenerator lottoNumberGenerator) {
        this.money = money;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int getPurchaseCount() {
        return money / LOTTO_PRICE;
    }

    public List<LottoNumber> purchaseLotto(int purchaseCount) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoNumbers.add(new LottoNumber(lottoNumberGenerator.generateSixNumbers()));
        }
        return lottoNumbers;
    }
}
