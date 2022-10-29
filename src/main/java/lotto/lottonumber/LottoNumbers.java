package lotto.lottonumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lotto.lottonumber.purchase.Purchase;

public class LottoNumbers {

    private static final String LINEBREAK = "\n";
    private static final String RESULT_HEADER_TEXT = "개를 구매했습니다." + LINEBREAK;
    private static final int MAKE_START_INDEX = 0;
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(Purchase purchase) {
        int lottoNumberCount = purchase.makeLottoNumberCount();
        for (int i = MAKE_START_INDEX; i < lottoNumberCount; i++) {
            lottoNumbers.add(new LottoNumber());
        }
    }

    public List<Iterator<Integer>> createIterators() {
        List<Iterator<Integer>> iterators = new ArrayList<>();
        lottoNumbers.forEach((lottoNumber) -> iterators.add(lottoNumber.createIterator()));
        return iterators;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder().append(lottoNumbers.size()).append(RESULT_HEADER_TEXT);
        for (LottoNumber lottoNumber : lottoNumbers) {
            result.append(lottoNumber.toString()).append(LINEBREAK);
        }
        return result.toString();
    }
}
