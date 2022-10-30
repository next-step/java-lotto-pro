package lotto.auto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private final int BEGIN_INDEX = 0;
    private final int LOTTO_NUMBER_LIST_SIZE = 6;

    private List<Integer> lottoNumbers;

    public LottoNumbers() {
        lottoNumbers = new ArrayList<>();
        makeLottoNumbers();
    }

    private void makeLottoNumbers() {
        for (int num = 1; num <= 45; num++) {
            lottoNumbers.add(num);
        }
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(BEGIN_INDEX, BEGIN_INDEX + LOTTO_NUMBER_LIST_SIZE);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
