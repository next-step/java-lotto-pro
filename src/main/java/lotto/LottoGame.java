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

    private final Amount amount;

    public LottoGame(int payment) {
        this.amount = new Amount(payment);
    }

    public int getAmount() {
        return amount.getAmount();
    }

    public int getPurchase() {
        return amount.getPurchase();
    }

    public void purchase(PurchaseQuantity quantity) {
        amount.purchase(quantity);
    }

    public List<LottoNumbers> autoPurchaseLotto(PurchaseQuantity quantity) {
        purchase(quantity);
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity.getPurchaseQuantity(); i++) {
            lottoNumbers.add(LottoNumbers.from(lottoNumberGenerator.autoGenerateNumbers()));
        }
        return lottoNumbers;
    }

    public List<LottoNumbers> manualPurchaseLotto(PurchaseQuantity quantity) {
        purchase(quantity);
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity.getPurchaseQuantity(); i++) {
            lottoNumbers.add(LottoNumbers.from(lottoNumberGenerator.manualGenerateNumbers()));
        }
        return lottoNumbers;
    }
}
