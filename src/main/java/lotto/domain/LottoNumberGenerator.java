package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator {

    public static final int MAX_COUNT = 6;

    public static final int NUMBER_RANGE_FROM = 1;

    public static final int NUMBER_RANGE_TO = 45;

    private static List<Integer> numberPool;

    static {
        numberPool = new ArrayList<>();
        for (int i = NUMBER_RANGE_FROM; i <= NUMBER_RANGE_TO; i++) {
            numberPool.add(i);
        }
    }

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

    @Override
    public List<Integer> generate(String numbers) {
        String[] stringNumbers = numbers.split(",");
        if (stringNumbers.length != 6) {
            throw new IllegalArgumentException("Array size should be 6.");
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < stringNumbers.length; i++) {
            result.add(Integer.parseInt(stringNumbers[i].trim()));
        }

        Collections.sort(result);
        return result;
    }

}
