package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.utils.LottoNumbersGenerator;

public class LottoStore {

    public static final Money pricePerLotto = Money.generate(1000);

    public Lottos sell(Money payment) {
        payment.validate(pricePerLotto);
        List<Lotto> lottoList = new ArrayList<>();
        for (int count = 0; count < payment.getPurchaseCount(pricePerLotto); count++) {
            Numbers random = LottoNumbersGenerator.random();
            lottoList.add(Lotto.generate(random));
        }
        return Lottos.generate(lottoList);
    }
}
