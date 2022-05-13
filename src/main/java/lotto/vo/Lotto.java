package lotto.vo;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        Collections.sort(numberList);
        this.numberList = numberList;
    }

    public int matchNumberCount(List<Integer> winningNumberList) {
        return Math.toIntExact(winningNumberList.stream()
                .filter(numberList::contains)
                .count());
    }

    public int[] numberListToArray() {
        return numberList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
