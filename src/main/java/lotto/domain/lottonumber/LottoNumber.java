package lotto.domain.lottonumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LottoNumber {

    private static final String RESULT_OPEN = "[";
    private static final String RESULT_CLOSE = "]";
    private static final String RESULT_SEPARATOR = " ,";
    private static final int RESULT_START_INDEX = 0;
    private static final int RESULT_END_INDEX = (-2);
    private static final int CREATE_START_INDEX = 0;
    private static final int CREATE_END_INDEX = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private List<Integer> lottoNumber;

    public LottoNumber() {
        lottoNumber = createLottoNumber();
        Collections.sort(lottoNumber);
    }

    public Iterator<Integer> createIterator() {
        return lottoNumber.iterator();
    }

    private List<Integer> createLottoNumber() {
        return createDefaultLottoNumber().subList(CREATE_START_INDEX, CREATE_END_INDEX);
    }

    private List<Integer> createDefaultLottoNumber() {
        List<Integer> defaultLottoNumber = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER + MIN_LOTTO_NUMBER; i++) {
            defaultLottoNumber.add(i);
        }
        Collections.shuffle(defaultLottoNumber);
        return defaultLottoNumber;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(RESULT_OPEN);
        for (Integer number : lottoNumber) {
            result.append(number).append(RESULT_SEPARATOR);
        }
        return result.substring(RESULT_START_INDEX, result.length() + RESULT_END_INDEX) + RESULT_CLOSE;
    }
}
