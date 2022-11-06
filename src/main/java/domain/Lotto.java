package domain;

import domain.strategy.NumberGenerateStrategy;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int SELL_PRICE = 1000;
    private static final int NUMBER_SIZE = 6;
    private static final List<Integer> TOTAL_NUMBER_POOL = IntStream.range(1, 45)
        .boxed()
        .collect(Collectors.toList());

    private final Set<Integer> numbers;

    public Lotto(NumberGenerateStrategy numberGenerateStrategy) {
        this.numbers = numberGenerateStrategy.generate(TOTAL_NUMBER_POOL, NUMBER_SIZE);
    }

    public LottoWinning findWinning(WinningNumber winningNumber) {
        int countOfMatch = winningNumber.countOfMatch(numbers);
        boolean isBonusNumberMatched = winningNumber.isBonusNumberMatched(numbers);
        return LottoWinning.of(countOfMatch, isBonusNumberMatched);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
