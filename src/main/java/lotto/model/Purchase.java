package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.InputUtils.convertToInteger;
import static lotto.view.InputView.readPurchaseAmount;
import static lotto.view.ResultView.printPurchaseCountView;

public class Purchase {
    private final Money purchaseAmount;
    private final int count;

    private Purchase(Money purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.count = purchaseAmount.purchaseCount();
    }

    public static Purchase createPurchase() {
        Money money = Money.of(convertToInteger(readPurchaseAmount()));
        return new Purchase(money);
    }

    public Lottos createLottos() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(LottoNumbers.createLottoNumbers());
        }
        return Lottos.from(lottoNumbers);
    }

    public Money getPurchaseAmount() {
        return purchaseAmount;
    }

    public void printPurchaseCount() {
        printPurchaseCountView(count);
    }
}
