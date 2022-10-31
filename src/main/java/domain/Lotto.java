package domain;

import domain.strategy.NumberGenerateStrategy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int SELL_PRICE = 1000;
    private static final int NUMBER_SIZE = 6;
    private static final List<Integer> TOTAL_NUMBER_POOL = IntStream.range(1, 45)
        .boxed()
        .collect(Collectors.toList());

    private final List<Integer> numbers;

    public Lotto(NumberGenerateStrategy numberGenerateStrategy) {
        this.numbers = numberGenerateStrategy.generate(TOTAL_NUMBER_POOL, NUMBER_SIZE);
    }

    public LottoWinning findWinning(List<Integer> winningNumbers) {
        return LottoWinning.of((int) numbers.stream()
            .filter(winningNumbers::contains)
            .count());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
