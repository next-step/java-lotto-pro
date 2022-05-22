package lotto.model;

import lotto.generator.AutoLottoNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private final Money purchaseAmount;
    private final int count;

    private Purchase(Money purchaseAmount, int count) {
        this.purchaseAmount = purchaseAmount;
        this.count = count;
    }

    public static Purchase createPurchase(int amount) {
        Money purchaseAmount = Money.of(amount);
        int count = purchaseAmount.purchaseCount();
        return new Purchase(purchaseAmount, count);
    }

    public Lottos createLottos() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(LottoNumbers.createLottoNumbers(new AutoLottoNumbersGenerator()));
        }
        return Lottos.from(lottoNumbers);
    }

    public Money getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getCount() {
        return count;
    }
}
