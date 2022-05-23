package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumberGenerator {

    public static final int MAX_COUNT = 6;

    public static final int NUMBER_RANGE_FROM = 1;

    public static final int NUMBER_RANGE_TO = 45;

    private static List<Integer> numberPool = IntStream.rangeClosed(NUMBER_RANGE_FROM, NUMBER_RANGE_TO)
            .boxed().collect(Collectors.toList());


    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumberPool = new ArrayList<>(numberPool);
        Collections.shuffle(lottoNumberPool);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= MAX_COUNT; i++) {
            numbers.add(lottoNumberPool.get(i));
        }

        Collections.sort(numbers);
        return numbers;
    }

}
