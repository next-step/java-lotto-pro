package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_FIRST_INDEX = 0;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_FIXED_PRICE = 1_000;
    private static final int IS_MATCHES = 1;
    private static final int IS_NOT_MATCHES = 0;
    private static final List<Integer> candidates = createLottoNumbers();

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = createSixRandomNumbers();
    }

    private List<Integer> createSixRandomNumbers() {
        Collections.shuffle(candidates);
        final List<Integer> sixNumbers = new ArrayList<>(candidates.subList(LOTTO_FIRST_INDEX, LOTTO_SIZE));
        Collections.sort(sixNumbers);
        return sixNumbers;
    }

    private static List<Integer> createLottoNumbers() {
        final List<Integer> candidates = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            candidates.add(i);
        }
        return candidates;
    }

    public int getNumbersCount() {
        return numbers.size();
    }

    public Integer getNumberByIndex(int index) {
        return numbers.get(index);
    }

    public int matches(final LottoWinningNumbers winningNumbers) {
        int matchesCount = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            matchesCount += matchesThenOneElseZero(winningNumbers.get(i));
        }
        return matchesCount;
    }

    private int matchesThenOneElseZero(final Integer winningNumber) {
        if(this.numbers.contains(winningNumber)) {
            return IS_MATCHES;
        }
        return IS_NOT_MATCHES;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (Integer number : numbers) {
            builder.append(" ")
                    .append(number)
                    .append(",");
        }
        return "[" + builder.substring(1, builder.length() - 1) + "]";
    }
}
