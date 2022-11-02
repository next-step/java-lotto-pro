package lotto.model.vo;

import java.util.ArrayList;
import java.util.List;
import lotto.model.constants.LottoConstants;

public class Lotto {

    private List<LottoNumber> lotto;

    public void addLottoNumber(LottoNumber lottoNumber) {
        if (this.lotto == null) {
            this.lotto = new ArrayList<>();
        }
        this.lotto.add(lottoNumber);
    }

    protected boolean checkLottoNumberCount() {
        return this.lotto.size() == LottoConstants.LOTTO_NUMBER_COUNT;
    }
}
