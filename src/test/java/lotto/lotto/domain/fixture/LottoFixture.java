package lotto.lotto.domain.fixture;

import lotto.lotto.domain.Lotto;

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

    public static List<Lotto> lottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(로또번호123456());
        lottos.add(로또번호124569());
        lottos.add(로또번호1456910());
        lottos.add(로또번호45691011());
        return lottos;
    }

    public static List<Lotto> 로또123456() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(로또번호123456());
        return lottos;
    }

    private static Lotto 로또번호45691011() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(9);
        numbers.add(10);
        numbers.add(11);
        return new Lotto(numbers);
    }

    private static Lotto 로또번호1456910() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(9);
        numbers.add(10);
        return new Lotto(numbers);
    }

    private static Lotto 로또번호124569() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(9);
        return new Lotto(numbers);
    }
}
