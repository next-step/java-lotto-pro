package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LottoStore {

    private static final int LOTTO_AMOUNT = 1000;
    private Supplier<LottoNumberGenerateStrategy> strategySupplier = RandomLottoNumberGenerateStrategy::new;

    public List<Lotto> payAll(PayAmount payAmount) {
        return pay(payAmount, new PayCount());
    }

    public List<Lotto> pay(PayAmount payAmount, PayCount payCount) {
        List<Lotto> sellLottoList = new ArrayList<>();
        while (payAmount.payable(LOTTO_AMOUNT) && payCount.remain()) {
            payAmount.pay(LOTTO_AMOUNT);
            sellLottoList.add(makeLotto(strategySupplier.get()));
        }
        return sellLottoList;
    }

    private Lotto makeLotto(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        return Lotto.valueOf(lottoNumberGenerateStrategy);
    }

    public void buyWith(Supplier<LottoNumberGenerateStrategy> strategySupplier) {
        this.strategySupplier = strategySupplier;
    }
}
