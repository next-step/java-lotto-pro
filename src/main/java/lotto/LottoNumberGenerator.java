package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private LottoNumberGenerator() {
    }

    public static List<Integer> generate() {
        return pickNumbers(shuffleAllNumbers());
    }

    private static List<Integer> pickNumbers(List<Integer> numbers) {
        List<Integer> pickNumbers = numbers.subList(0, 6);
        Collections.sort(pickNumbers);
        return pickNumbers;
    }

    private static List<Integer> shuffleAllNumbers() {
        List<Integer> allNumbers = allNumbers();
        Collections.shuffle(allNumbers);
        return allNumbers;
    }

    private static List<Integer> allNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=45; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
