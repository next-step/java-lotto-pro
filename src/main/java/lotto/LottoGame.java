/*
 * LottoGame.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final TotalMoney totalMoney;
    private final Balance balance;

    public LottoGame(int totalMoney) {
        this.totalMoney = new TotalMoney(totalMoney);
        this.balance = new Balance(totalMoney);
    }

    public int getTotalMoney() {
        return totalMoney.getTotalMoney();
    }

    public int getBalance() {
        return balance.getBalance();
    }

    public int getPurchasableCount() {
        return balance.getPurchasableCount();
    }

    public void minusBalance() {
        balance.minusBalance();
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
