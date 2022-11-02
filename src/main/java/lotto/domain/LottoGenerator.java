package lotto.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface LottoGenerator {
    int LOTTO_NUMBER_COUNT = 6;
    List<Integer> availableNumbers =
            Stream.iterate(1, number -> number + 1)
                    .limit(45)
                    .collect(Collectors.toList());

    List<Integer> create(Supplier<List<Integer>> numbersSupplier);
}
