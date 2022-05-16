package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoPickNumberStrategy implements PickNumberStrategy {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();
    private static final int LOTTO_NUMBER_COUNT = 6;

    public AutoPickNumberStrategy() {
        for (int i = LottoNumber.LOWER_BOUND + 1; i < LottoNumber.UPPER_BOUND; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    @Override
    public List<LottoNumber> pickLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> pickNumbers = this.lottoNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(pickNumbers);
        return pickNumbers;
    }
}
