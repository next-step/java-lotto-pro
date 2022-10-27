package step3.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.domain.Numbers;

public class LottoNumbersGenerator {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int MAX_SELECT_NUMBER = 6;

    public static Numbers random() {
        List<Integer> randomNumbers = IntStream.range(START_NUMBER, END_NUMBER)
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
        return Numbers.generate(randomNumbers);
    }
}
