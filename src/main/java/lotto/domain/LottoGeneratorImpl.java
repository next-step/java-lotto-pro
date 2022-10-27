package lotto.domain;

import lotto.ui.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGeneratorImpl implements LottoGenerator {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final List<Integer> availableNumbers =
            Stream.iterate(1, number -> number + 1)
                    .limit(45)
                    .collect(Collectors.toList());

    @Override
    public List<Integer> create() {
        Collections.shuffle(availableNumbers);
        List<Integer> numbers = availableNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        ResultView.printMessage(numbers.toString());
        return numbers;
    }
}
