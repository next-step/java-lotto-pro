package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottosGenerator {
    public static Lottos purchaseLottos(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < money.lottoCountToBuy(); i++) {
            lottoList.add(new Lotto(RandomLottoNumbersGenerator.generate()));
        }
        return new Lottos(lottoList);
    }
}
