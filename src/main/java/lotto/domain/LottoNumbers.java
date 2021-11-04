package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MAX_SIZE = 6;
    private static final List<LottoNumber> DEFAULT_LOTTO_NUMBERS =
            IntStream.range(MIN_NUMBER, MAX_NUMBER + 1).mapToObj(LottoNumber::new).collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers create() {
        ArrayList<LottoNumber> numbers = new ArrayList<>(DEFAULT_LOTTO_NUMBERS);
        Collections.shuffle(numbers);
        return new LottoNumbers(numbers.subList(0, MAX_SIZE));
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
