package lotto.model;

import java.util.List;

public class LottoGenerator {

    public static Lotto generateLotto(List<Integer> numberList) {
        return new Lotto(numberList);
    }
}
