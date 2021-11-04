package lotto.service;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoAutoCreateFactory {
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_LAST_NUMBER = 45;
    private final static int LOTTO_SIZE = 6;

    public static Lotto createLotto() {
        int[] randomNumbers = createRandomNumbers();
        Lotto lotto = new Lotto(randomNumbers);
        return lotto;
    }

    private static int[] createRandomNumbers() {
        List<Integer> numbers = makeNumbers();
        Collections.shuffle(numbers);
        int[] result = new int[LOTTO_SIZE];
        for (int i = 0; i < LOTTO_SIZE; i++) {
            result[i] = numbers.get(i);
        }
        Arrays.sort(result);
        return result;
    }

    private static List<Integer> makeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public static Lottos createLottos(int size) {
        Lotto[] lottoArray = new Lotto[size];
        for (int i = 0; i < size; i++) {
            lottoArray[i] = createLotto();
        }
        return new Lottos(lottoArray);
    }
}
