package lotto.model;

import lotto.generator.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private final Money purchaseAmount;
    private final int manualCount;
    private final int autoCount;

    public Purchase(Money purchaseAmount, int manualCount, int autoCount) {
        this.purchaseAmount = purchaseAmount;
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public static Purchase createPurchase(int amount, int manualCount) {
        Money purchaseAmount = Money.of(amount);
        int totalCount = purchaseAmount.purchaseCount();
        return new Purchase(purchaseAmount, manualCount, totalCount - manualCount);
    }

    public Lottos createLottos(LottoNumbersGenerator lottoNumbersGenerator, int count) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(LottoNumbers.createLottoNumbers(lottoNumbersGenerator));
        }
        return Lottos.from(lottoNumbers);
    }

    public Money getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
