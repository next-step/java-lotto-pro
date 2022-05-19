package lotto.service;

import static lotto.domain.LottoCondition.AMOUNT_OF_NUMBERS;
import static lotto.domain.LottoCondition.MAXIMUM_NUMBER;
import static lotto.domain.LottoCondition.MINIMUM_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoNumbersIssuer {
    private static final List<Integer> NUMBER_CANDIDATES = IntStream.range(MINIMUM_NUMBER.getCondition(),
                    MAXIMUM_NUMBER.getCondition() + 1)
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> issueNumbers() {
        Collections.shuffle(NUMBER_CANDIDATES);
        final List<Integer> numbers = new ArrayList<>(NUMBER_CANDIDATES.subList(0, AMOUNT_OF_NUMBERS.getCondition()));
        Collections.sort(numbers);
        return numbers;
    }
}
