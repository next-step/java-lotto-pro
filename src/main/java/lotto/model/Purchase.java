package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.InputUtils.convertToInteger;
import static lotto.view.InputView.readPurchaseAmount;

public class Purchase {
    private final Money money;
    private final int count;

    private Purchase(Money money) {
        this.money = money;
        this.count = money.purchaseCount();
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
}