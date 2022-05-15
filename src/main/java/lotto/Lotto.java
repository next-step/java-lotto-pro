package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    final int LOTTO_MIN_NUMBER = 1;
    final int LOTTO_MAX_NUMBER = 45;
    final int LOTTO_COUNT = 6;
    final String LOTTO_PRINT_START_CHAR = "[";
    final String LOTTO_PRINT_END_CHAR = "]";
    final String LOTTO_PRINT_DELIMITER = ", ";

    private List<Integer> lottoNumbers;

    public Lotto() {
        createRandomLottoNumber();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void createRandomLottoNumber() {
        List<Integer> list = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i < LOTTO_MAX_NUMBER; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        lottoNumbers = list.subList(0, LOTTO_COUNT);
        Collections.sort(lottoNumbers);
    }

    public void printLotto() {
        System.out.print(LOTTO_PRINT_START_CHAR);

        for (int i = 0; i < LOTTO_COUNT - 1; i++) {
            System.out.print(lottoNumbers.get(i));
            System.out.print(LOTTO_PRINT_DELIMITER);
        }

        System.out.print(lottoNumbers.get(LOTTO_COUNT - 1));
        System.out.println(LOTTO_PRINT_END_CHAR);
    }
}