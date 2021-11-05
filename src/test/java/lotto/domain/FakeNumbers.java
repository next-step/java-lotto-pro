package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class FakeNumbers implements Numbers {

    private int index;
    private List<List<Integer>> list = Arrays.asList(
            Arrays.asList(1, 2, 3, 4, 5, 6),
            Arrays.asList(11, 12, 13, 14, 15, 16));

    @Override
    public List<Integer> random() {
        return list.get(index++);
    }
}
