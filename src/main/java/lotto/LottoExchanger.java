package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoGenerator;
import lotto.money.Money;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class LottoExchanger {

    private final LottoGenerator lottoGenerator;

    public LottoExchanger(LottoGenerator lottoGenerator) {
        this.lottoGenerator = requireNonNull(lottoGenerator, "lottoGenerator");
    }

    LottoExchanger() {
        this(LottoGenerator.random());
    }

    public List<Lotto> exchange(Money money) {
        final List<Lotto> purchasedLottoes = new ArrayList<>();
        Money remainMoney = money;
        while (true) {
            final Lotto lotto = lottoGenerator.generate();
            if (!remainMoney.canPurchase(lotto)) {
                break;
            }
            remainMoney = remainMoney.purchase(lotto);
            purchasedLottoes.add(lotto);
        }
        if (purchasedLottoes.isEmpty()) {
            throw new NothingToPurchasedLottoException();
        }
        return purchasedLottoes;
    }
}
