package lotto.domain;

import java.util.*;

public class RandomNumbers implements Numbers{

    private static final int MAX_SIZE = 6;

    private Number number;

    public RandomNumbers(final Number number) {
        this.number = number;
    }

    @Override
    public List<Integer> random() {
        final List list = new ArrayList(getRandomNumbers());
        Collections.shuffle(list);
        return list;
    }

    private Set<Integer> getRandomNumbers() {
        final Set<Integer> numbers = new HashSet();
        while (numbers.size() < MAX_SIZE) {
            numbers.add(number.generate());
        }
        return numbers;
    }
}
