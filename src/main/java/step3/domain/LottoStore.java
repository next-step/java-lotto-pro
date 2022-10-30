package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.utils.NumbersGenerator;

public class LottoStore {

    public static final Money pricePerLotto = Money.generate(1000);

    public Lottos sell(Money payment) {
        validate(payment);
        List<Lotto> lottoList = new ArrayList<>();
        int divide = payment.divide(pricePerLotto);
        for (int count = 0; count < divide; count++) {
            UniqueNumbers random = NumbersGenerator.random();
            lottoList.add(Lotto.generate(random));
        }
        return Lottos.generate(lottoList);
    }

    private void validate(Money payment) {
        if (payment.divide(pricePerLotto) == 0) {
            throw new IllegalArgumentException("You don't have enough money.");
        }
    }
}
