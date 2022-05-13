package study.lotto.domain.sorter;

import java.util.Collections;
import java.util.List;

public class IntegerAscendingSorter implements IntegerSorter {
    @Override
    public void sort(List<Integer> sort) {
        Collections.sort(sort);
    }
}
