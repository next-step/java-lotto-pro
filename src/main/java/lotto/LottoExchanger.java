package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoGenerator;
import lotto.lotto.ManualLottoes;
import lotto.money.Money;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class LottoExchanger {

    private final LottoGenerator lottoGenerator;

    public LottoExchanger(LottoGenerator lottoGenerator) {
        this.lottoGenerator = requireNonNull(lottoGenerator, "lottoGenerator");
    }

    public List<Lotto> exchange(Money money, ManualLottoes manualLottoes) {
        final List<Lotto> purchasedLottoes = new ArrayList<>();
        Money remainMoney = money;
        validateMoney(remainMoney, Lotto.PRICE);
        while (remainMoney.canDeduct(Lotto.PRICE)) {
            final Lotto lotto = lottoGenerator.generate();
            remainMoney = remainMoney.deduct(lotto.price());
            purchasedLottoes.add(lotto);
        }
        return purchasedLottoes;
    }

    private static void validateMoney(Money remainMoney, Money price) {
        if (!remainMoney.canDeduct(price)) {
            throw new NotEnoughMoneyException(remainMoney, price);
        }
    }
}
