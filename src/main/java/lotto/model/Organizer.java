package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Organizer {
    private static final int COMPARE_TRUE = 1;
    private static final int COMPARE_FALSE = 0;

    private final List<Integer> winnerNumbers;
    private int sameCount = 0;

    public Organizer(String number) {
        winnerNumbers = Arrays.stream(number.split(","))
                .map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int compareResult(List<Integer> userLotto) {
        for (int number : userLotto) {
            this.sameCount += compare(number);
        }
        return this.sameCount;
    }

    private int compare(int number) {
        return this.winnerNumbers.contains(number) ? COMPARE_TRUE : COMPARE_FALSE;
    }
}
