package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final List<Integer> numbers = IntStream
            .rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static List<LottoNumbers> generate(int quantity) {
        List<LottoNumbers> result = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Collections.shuffle(numbers);
            List<Integer> randomNumbers = numbers.stream()
                    .limit(LOTTO_SIZE)
                    .collect(Collectors.toList());
            result.add(new LottoNumbers(randomNumbers));
        }

        return result;
    }
}
