package domain;

import domain.strategy.NumberGenerateStrategy;
import java.util.Collections;
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

    public LottoWinning findWinning(List<Integer> winningNumber) {
        Collections.sort(numbers);
        Collections.sort(winningNumber);

        int numberMatchSize = 0;
        for (int i = 0; i < numbers.size(); i++) {
            numberMatchSize += numbers.get(i).equals(winningNumber.get(i)) ? 1 : 0;
        }
        return LottoWinning.of(numberMatchSize);
    }
}
