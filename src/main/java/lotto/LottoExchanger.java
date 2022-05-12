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
        Lotto lotto = lottoGenerator.generate();
        while (remainMoney.canPurchase(lotto)) {
            remainMoney = remainMoney.purchase(lotto);
            purchasedLottoes.add(lotto);
            lotto = lottoGenerator.generate();
        }
        validateSize(purchasedLottoes, money, lotto);
        return purchasedLottoes;
    }

    private void validateSize(List<Lotto> purchasedLottoes, Money money, Lotto lotto) {
        if (purchasedLottoes.isEmpty()) {
            throw new NothingToPurchasedLottoException(money, lotto);
        }
    }
}
