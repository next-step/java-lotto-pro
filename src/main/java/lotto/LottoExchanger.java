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
        validateMoney(remainMoney, lotto);
        while (remainMoney.canDeduct(lotto)) {
            remainMoney = remainMoney.deduct(lotto);
            purchasedLottoes.add(lotto);
            lotto = lottoGenerator.generate();
        }
        return purchasedLottoes;
    }

    private void validateMoney(Money remainMoney, Lotto lotto) {
        if (!remainMoney.canDeduct(lotto)) {
            throw new NotEnoughMoneyException(remainMoney, lotto);
        }
    }
}
