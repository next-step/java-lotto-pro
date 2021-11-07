package lotto.module;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.common.LottoConst.*;

public class AutoGenerator implements NumberGeneratorStrategy {
    private static final List<Integer> ALL_LOTTO_NUMBERS = createNumbers();

    private int autoBoughtCount;

    public AutoGenerator(int autoBoughtCount) {
        this.autoBoughtCount = autoBoughtCount;
    }

    private static List<Integer> createNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumbers> createLottos() {
        return IntStream.range(0, autoBoughtCount)
                .mapToObj(i -> generateRandomLottoNumbers())
                .collect(Collectors.toList());
    }

    private LottoNumbers generateRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(ALL_LOTTO_NUMBERS);
        Collections.shuffle(numbers);

        return LottoNumbers.fromList(numbers.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList()));
    }
}
