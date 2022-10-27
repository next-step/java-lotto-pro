package step3;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int MAX_SELECT_NUMBER = 6;

    private final LottoNumbers numbers;

    private Lotto() {
        List<Integer> numbers = generateAutoNumbers();
        this.numbers = LottoNumbers.generate(numbers);
    }

    private List<Integer> generateAutoNumbers() {
        return IntStream.range(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    Collections.shuffle(list);
                                    list = list.subList(0, MAX_SELECT_NUMBER);
                                    Collections.sort(list);
                                    return list;
                                }
                        ));
    }

    public static Lotto generate() {
        return new Lotto();
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }
}
