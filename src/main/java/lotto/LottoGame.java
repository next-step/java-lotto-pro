/*
 * LottoGame.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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

    public void isPurchase(Quantity quantity) {
        amount.isPurchase(quantity);
    }

    public List<Lotto> purchaseLotto(Quantity quantity) {
        purchase(quantity);
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity.getQuantity(); i++) {
            lottoNumbers.add(lottoNumberGenerator.autoGenerateNumbers());
        }
        return lottoNumbers;
    }

    public List<Lotto> purchaseLotto(Quantity quantity, Supplier<Lotto> supplier) {
        purchase(quantity);
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity.getQuantity(); i++) {
            lottoNumbers.add(lottoNumberGenerator.manualGenerateNumbers(supplier));
        }
        return lottoNumbers;
    }
}
