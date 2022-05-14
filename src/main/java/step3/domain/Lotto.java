package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;
    public final static int LOTTO_FIRST_INDEX = 0;
    public final static int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = createSixRandomNumbers();
    }

    private List<Integer> createSixRandomNumbers() {
        final List<Integer> candidates = createLottoNumbers();
        Collections.shuffle(candidates);
        final List<Integer> sixNumbers = new ArrayList<>(candidates.subList(LOTTO_FIRST_INDEX, LOTTO_SIZE));
        Collections.sort(sixNumbers);
        return sixNumbers;
    }

    private List<Integer> createLottoNumbers() {
        final List<Integer> candidates = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            candidates.add(i);
        }
        return candidates;
    }

    public int size() {
        return numbers.size();
    }

    public Integer get(int index) {
        return numbers.get(index);
    }
}
