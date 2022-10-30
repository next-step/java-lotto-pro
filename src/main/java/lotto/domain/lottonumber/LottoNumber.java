package lotto.domain.lottonumber;

import java.util.Iterator;
import java.util.List;

public class LottoNumber {

    private static final String RESULT_OPEN = "[";
    private static final String RESULT_CLOSE = "]";
    private static final String RESULT_SEPARATOR = ", ";
    private List<Integer> lottoNumber;

    public LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Iterator<Integer> createIterator() {
        return lottoNumber.iterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(RESULT_OPEN);
        for (Integer number : lottoNumber) {
            result.append(number).append(RESULT_SEPARATOR);
        }
        return result.substring(0, result.length() - 2) + RESULT_CLOSE;
    }
}
