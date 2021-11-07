package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.LottoNumber;
import lotto.util.ConstantString;
import lotto.view.ErrorMessage;

import java.util.*;

public class LottoCreateFactory {

    public static Lotto createRandomLotto() {
        int[] randomNumbers = createRandomNumbers();
        Lotto lotto = new Lotto(randomNumbers);
        return lotto;
    }

    private static int[] createRandomNumbers() {
        List<Integer> numbers = makeNumbers();
        Collections.shuffle(numbers);
        int[] result = new int[LottoNumber.SIZE];
        for (int i = 0; i < LottoNumber.SIZE; i++) {
            result[i] = numbers.get(i);
        }
        Arrays.sort(result);
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

    public static Lotto createLotto(int[] numbers) {
        if (validDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR);
        }
        return new Lotto(numbers);
    }

    private static boolean validDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            set.add(numbers[i]);
        }
        return set.size() != LottoNumber.SIZE;
    }

}
