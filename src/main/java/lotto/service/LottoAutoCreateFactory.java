package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoAutoCreateFactory {
    public static final int LOTTO_SIZE = 6;
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
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
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
