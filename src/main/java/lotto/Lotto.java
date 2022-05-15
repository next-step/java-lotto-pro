package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto() {
        createRandomLottoNumber();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void createRandomLottoNumber() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 45; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        lottoNumbers = list.subList(0, 6);
        Collections.sort(lottoNumbers);
    }
}