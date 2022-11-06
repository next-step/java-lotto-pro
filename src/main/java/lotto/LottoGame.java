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

    public LottoGame(String payment) {
        Validate.isEmpty(payment);
        Validate.isNumber(payment);
        Validate.isPurchasable(payment);
        this.amount = new Amount(Integer.parseInt(payment));
    }

    public int getAmount() {
        return amount.getAmount();
    }

    public int getPurchase() {
        return amount.getPurchase();
    }

    public void purchase(Quantity quantity) {
        amount.purchase(quantity);
    }

    public List<LottoNumbers> autoPurchaseLotto(Quantity quantity) {
        purchase(quantity);
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity.getQuantity(); i++) {
            lottoNumbers.add(LottoNumbers.from(lottoNumberGenerator.autoGenerateNumbers()));
        }
        return lottoNumbers;
    }

    public List<LottoNumbers> manualPurchaseLotto(Quantity quantity) {
        purchase(quantity);
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity.getQuantity(); i++) {
            lottoNumbers.add(LottoNumbers.from(lottoNumberGenerator.manualGenerateNumbers()));
        }
        return lottoNumbers;
    }

    public void isPurchase(Quantity quantity) {
        amount.isPurchase(quantity);
    }
}
