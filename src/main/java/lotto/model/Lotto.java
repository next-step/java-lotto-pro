package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numberList, lotto.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }
}
