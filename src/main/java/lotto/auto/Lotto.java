package lotto.auto;

import java.util.Collections;
import java.util.List;

import static lotto.auto.common.Constants.BEGIN_INDEX;
import static lotto.auto.common.Constants.LOTTO_LENGTH;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto() {
        lottoNumbers = new LottoNumbers();
        makeLottoNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }

    private void makeLottoNumbers() {
        for (int num = 1; num <= 45; num++) {
            lottoNumbers.add(num);
        }
        Collections.shuffle(lottoNumbers.getNumbers());
        lottoNumbers = new LottoNumbers(lottoNumbers.getNumbers().subList(BEGIN_INDEX, BEGIN_INDEX + LOTTO_LENGTH));
        Collections.sort(lottoNumbers.getNumbers());
    }

    @Override
    public String toString() {
        return lottoNumbers.getNumbers().toString();
    }
}
