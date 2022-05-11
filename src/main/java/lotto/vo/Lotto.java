package lotto.vo;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        Collections.sort(numberList);
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
