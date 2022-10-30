package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step3.enums.Rule;

public class LottoNumber {

    private List<Integer> lottoNumber;

    public LottoNumber() {
    }

    public LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = new ArrayList<>(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    public List<Integer> gainSixAutoLottoNumbers(Range range) {
        Collections.shuffle(range.getRange());
        lottoNumber = range.getRange().subList(Rule.LOTTO_START_NUMBER.getRange(), Rule.LOTTO_END_NUMBER.getRange());
        return lottoNumber;
    }

}


