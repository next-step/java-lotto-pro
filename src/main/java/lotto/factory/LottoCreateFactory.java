package lotto.factory;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.LottoNumber;
import lotto.view.ErrorMessage;

import java.util.*;

public class LottoCreateFactory {

    public static Lotto createRandomLotto() {
        List<Integer> randomNumbers = createRandomNumbers();
        Lotto lotto = new Lotto(randomNumbers);
        return lotto;
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> numbers = makeNumbers();
        Collections.shuffle(numbers);
        List<Integer> result = numbers.subList(0, Lotto.SIZE);
        Collections.sort(result);
        return result;
    }

    private static List<Integer> makeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public static Lottos createLottos(int size) {
        Lotto[] lottoArray = new Lotto[size];
        for (int i = 0; i < size; i++) {
            lottoArray[i] = createRandomLotto();
        }
        return new Lottos(lottoArray);
    }

    public static Lotto createLotto(List<Integer> numbers) {
        if (validDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR);
        }
        return new Lotto(numbers);
    }

    private static boolean validDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            set.add(number);
        }
        return set.size() != Lotto.SIZE;
    }

}
