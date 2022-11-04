package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottosFixture {
    public static Lottos 로또번호123456() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        return new Lottos(numbers);
    }

    public static Lottos 로또번호123457() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        return new Lottos(numbers);
    }

}
