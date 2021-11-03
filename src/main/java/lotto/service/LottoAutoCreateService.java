package lotto.service;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoCreateService {
    private List<Integer> numbers;
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_LAST_NUMBER = 45;
    private final static int LOTTO_SIZE = 6;

    public LottoAutoCreateService() {
        this.numbers = new ArrayList<>();
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            numbers.add(i);
        }
    }

    public Lotto createLotto() {
        int [] randomNumbers = createRandomNumbers();
        Lotto lotto = new Lotto(randomNumbers);
        return lotto;
    }

    private int[] createRandomNumbers() {
        Collections.shuffle(numbers);
        int [] result = new int[LOTTO_SIZE];
        for (int i = 0; i < LOTTO_SIZE; i++) {
            result[i]=numbers.get(i);
        }
        return result;
    }
}
