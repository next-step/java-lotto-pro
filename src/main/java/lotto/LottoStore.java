package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int LOTTO_AMOUNT = 1000;

    public List<Lotto> pay(PayAmount payAmount) {
        List<Lotto> sellLottoList = new ArrayList<>();
        while (payAmount.payable(LOTTO_AMOUNT)) {
            payAmount.pay(LOTTO_AMOUNT);
            sellLottoList.add(makeLotto(new RandomLottoNumberGenerateStrategy()));
        }
        return sellLottoList;
    }

    private Lotto makeLotto(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        return Lotto.valueOf(lottoNumberGenerateStrategy);
    }
}
