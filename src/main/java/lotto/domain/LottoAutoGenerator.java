package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<Integer> LOTTO_NUMBERS = initializeNumbers();


    public static List<Integer> makeNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LottoNumbers.LOTTO_DIGITS; i++) {
            numbers.add(LOTTO_NUMBERS.get(i));
        }
        Collections.sort(numbers);
        
        return numbers;
    }

    private static List<Integer> initializeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
