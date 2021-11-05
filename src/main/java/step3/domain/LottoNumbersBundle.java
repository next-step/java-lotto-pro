package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersBundle {
    private final List<LottoNumbers> lottoNumbersBundle = new ArrayList<>();

    public LottoNumbersBundle() {
    }

    public void addLottoNumbers(LottoNumbers lottoNumbers) {
        lottoNumbersBundle.add(lottoNumbers);
    }

    public int size() {
        return lottoNumbersBundle.size();
    }
}
