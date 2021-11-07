package lotto.domain;

import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;

public class LottoMachine {

    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int LOTTO_PRICE = 1000;
    private NumberGenerator generator;

    public LottoMachine(NumberGenerator generator) {
        this.generator = generator;
    }

    public Lottos issue(PurchaseAmount amount) {
        long lottoCount = amount.divide(new Amount(LOTTO_PRICE));
        List<Lotto> lottos = LongStream.rangeClosed(1, lottoCount)
                .mapToObj(n -> issue())
                .collect(toList());

        return new Lottos(lottos);
    }

    private Lotto issue() {
        return new Lotto(generator.generate(LOTTO_NUMBER_COUNT));
    }
}
