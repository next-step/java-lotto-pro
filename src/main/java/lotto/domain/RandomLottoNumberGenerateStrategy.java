package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final List<Integer> CACHED_NUMBER = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed()
            .collect(Collectors.toList());
    private static final int MAX_SIZE = 6;

    @Override
    public Set<Integer> generate() {
        Collections.shuffle(CACHED_NUMBER);
        return CACHED_NUMBER.stream()
                .limit(MAX_SIZE)
                .collect(Collectors.toSet());
    }
}
