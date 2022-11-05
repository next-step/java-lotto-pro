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
    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final int totalMoney;
    private int balance;

    public LottoGame(int totalMoney) {
        this.totalMoney = totalMoney;
        this.balance = totalMoney;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public int getBalance() {
        return balance;
    }

    public int getAutoPurchasableCount() {
        return balance / LOTTO_PRICE;
    }

    public void minusBalance() {
        if (balance < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        balance -= LOTTO_PRICE;
    }

    public List<LottoNumbers> autoPurchaseLotto(int purchaseCount) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            minusBalance();
            lottoNumbers.add(LottoNumbers.from(lottoNumberGenerator.autoGenerateNumbers()));
        }
        return lottoNumbers;
    }

    public List<LottoNumbers> manualPurchaseLotto(int purchaseCount) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            minusBalance();
            lottoNumbers.add(LottoNumbers.from(lottoNumberGenerator.manualGenerateNumbers()));
        }
        return lottoNumbers;
    }
}
