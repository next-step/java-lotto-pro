package lotto;

import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final int MAX_COUNT = 6;

    private ArrayList<Integer> numbers;

    public LottoNumbers() {
        this.numbers = new ArrayList<>();
        this.initWithRandomNumber();
    }

    public Object[] getNumbersAsArray() {
        return numbers.toArray();
    }

    private void initWithRandomNumber() {
        List<Integer> lottoNumberPool = this.generateLottoNumberPool();
        Collections.shuffle(lottoNumberPool);
        for (int i = 1; i <= MAX_COUNT; i++) {
            this.numbers.add(lottoNumberPool.get(i));
        }
        Collections.sort(this.numbers);
    }

    private List<Integer> generateLottoNumberPool() {
        List<Integer> numberPool = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numberPool.add(i);
        }
        return numberPool;
    }
}
