package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    final int LOTTO_MIN_NUMBER = 1;
    final int LOTTO_MAX_NUMBER = 45;
    final int LOTTO_COUNT = 6;

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

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

    public int checkMatchCount(Lotto checkLotto) {
        int countMatch = 0;
        for (Integer lotto : checkLotto.getLottoNumbers()) {
            countMatch = lottoNumbers.contains(lotto) ? countMatch + 1 : countMatch;
        }
        return countMatch;
    }
}