package lotto.module;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.common.LottoConst.*;

public class AutoGenerator implements NumberGeneratorStrategy {

    public static final List<Integer> ALL_LOTTO_NUMBERS = createNumbers();

    private AutoGenerator() {
    }

    public static AutoGenerator getInstance() {
        return AutoGenerator.LazyHolder.INSTANCE;
    }

    private static List<Integer> createNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public LottoNumbers createLotto() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(ALL_LOTTO_NUMBERS);
        Collections.shuffle(numbers);

        return LottoNumbers.fromList(numbers.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList()));
    }

    private static class LazyHolder {
        public static final AutoGenerator INSTANCE = new AutoGenerator();
    }
}
