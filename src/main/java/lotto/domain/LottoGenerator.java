package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final List<Integer> numbers;

    static {
        numbers = generateCandidateNumbers();
    }

    private LottoGenerator() {
    }

    public static Lotto generate() {
        return new Lotto(getSortedLottoNumbers());
    }

    private static List<Integer> generateCandidateNumbers() {
        return IntStream.range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> getSortedLottoNumbers() {
        Collections.shuffle(numbers);
        List<Integer> generatedNumbers = new ArrayList<>(numbers.subList(0, Lotto.LOTTO_NUMBERS_SIZE));
        Collections.sort(generatedNumbers);
        return generatedNumbers;
    }
}
