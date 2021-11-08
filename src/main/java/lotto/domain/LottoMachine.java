package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.*;

public class LottoMachine {

    private final static int LOTTO_NUMBER_COUNT = 6;
    public final static int LOTTO_PRICE = 1000;
    private NumberSupplier numberSupplier;

    public LottoMachine(NumberSupplier generator) {
        this.numberSupplier = generator;
    }

    public Lottos issueAuto(Amount amount) {
        long lottoCount = amount.divide(new Amount(LOTTO_PRICE));
        List<Lotto> lottos = LongStream.rangeClosed(1, lottoCount)
                .mapToObj(n -> issueAuto())
                .collect(toList());

        return new Lottos(lottos);
    }

    private Lotto issueAuto() {
        return new Lotto(numberSupplier.getAsInts(LOTTO_NUMBER_COUNT));
    }

    public Lottos issueManual(List<String> numbers) {
        List<Lotto> lottos = numbers.stream()
                .map(n -> Arrays.stream(n.split(",")).map(String::trim).map(Integer::parseInt).collect(toList()))
                .map(Lotto::new)
                .collect(toList());

        return new Lottos(lottos);
    }
}
