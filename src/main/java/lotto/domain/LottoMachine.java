package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
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

    public Lottos issueAuto(PurchaseAmount amount) {
        long lottoCount = amount.divide(new Amount(LOTTO_PRICE));
        List<Lotto> lottos = LongStream.rangeClosed(1, lottoCount)
                .mapToObj(n -> issueAuto())
                .collect(toList());

        return new Lottos(lottos);
    }

    private Lotto issueAuto() {
        return new Lotto(generator.generate(LOTTO_NUMBER_COUNT));
    }

    public Lottos issueManual(List<String> numbers) {
        List<Lotto> lottos = numbers.stream()
                .map(n -> Arrays.stream(n.split(",")).map(String::trim).map(Integer::parseInt).collect(toList()))
                .map(Lotto::new)
                .collect(toList());

        return new Lottos(lottos);
    }
}
