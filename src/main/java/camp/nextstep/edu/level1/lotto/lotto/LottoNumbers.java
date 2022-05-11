package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.until.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private final static int LOTTO_RANGE = 6;
    private final static String PRINT_JOIN_DELIMITER = ", ";
    private final static String TO_STRING_PREFIX = "[";
    private final static String TO_STRING_SUFFIX = "]";

    private List<LottoNumber> value = new ArrayList<>();

    public LottoNumbers() {
        Set<Integer> numbers = RandomGenerator
                .createNonDuplicatedIntegerSet(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_RANGE);

        for (Integer number : numbers) {
            this.add(number);
        }
    }

    @Override
    public String toString() {
        return TO_STRING_PREFIX + this.value.stream()
                .map(value -> Integer.toString(value.getValue()))
                .collect(Collectors.joining(PRINT_JOIN_DELIMITER)) + TO_STRING_SUFFIX;
    }

    private void add(int value) {
        this.value.add(new LottoNumber(value));
    }
}
