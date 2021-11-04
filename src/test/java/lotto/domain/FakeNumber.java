package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class FakeNumber implements Number {

    private List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    private int index;

    @Override
    public int generate() {
        return numbers.get(index++);
    }
}