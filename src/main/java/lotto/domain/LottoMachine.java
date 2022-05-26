package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    public static final LottoMachine INSTANCE = new LottoMachine();
    private static final int NUMBER_START = 1;
    private static final int NUMBER_END = 46;
    private static final List<Integer> NUMBERS = IntStream.range(NUMBER_START, NUMBER_END).boxed().collect(Collectors.toList());
    private static final int LOTTO_SIZE_LIMIT = 6;
    private static final int PRICE = 1_000;
    private static final int MIN_RANGE = 0;

    private LottoMachine() {}

    public static LottoMachine getInstance() {
        return INSTANCE;
    }

    public int purchase(final long money) {
        return calculate(new Money(money));
    }

    private int calculate(final Money money) {
        validate(money.getValue());
        return (int) (money.getValue() / PRICE);
    }

    private void validate(final long money) {
        if (money < PRICE) {
            throw new LottoException(LottoExceptionType.LOTTO_MONEY_LEAK);
        }
    }

    public List<Lotto> buyLottos(final List<String> lottoes, final int autoCount) {
        List<Lotto> manualLottoes = generateManual(lottoes);
        List<Lotto> autoLottoes = generateAutos(autoCount);

        return mergeLotto(manualLottoes, autoLottoes);
    }

    private List<Lotto> generateManual(final List<String> lottoes) {
        return lottoes.stream()
                .map(Lotto::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Lotto> generateAutos(final int count) {
        return IntStream.range(MIN_RANGE, count)
                .mapToObj(v -> this.generateAuto())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Lotto generateAuto() {
        shuffle();
        List<LottoNumber> lottoNumbers = NUMBERS.stream()
                .limit(LOTTO_SIZE_LIMIT)
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(ArrayList::new));

        return new Lotto(lottoNumbers);
    }

    private ArrayList<Lotto> mergeLotto(List<Lotto> manualLottoes, List<Lotto> autoLottoes) {
        return Stream.concat(manualLottoes.stream(), autoLottoes.stream())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void shuffle() {
        Collections.shuffle(NUMBERS);
    }


}
