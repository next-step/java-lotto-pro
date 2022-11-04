package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFixture {
    public static Lotto 로또번호123456() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        return new Lotto(numbers);
    }

    public static Lotto 로또번호123457() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        return new Lotto(numbers);
    }

}
