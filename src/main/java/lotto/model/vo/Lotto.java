package lotto.model.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
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

    public void print() {
        System.out.println("[");
        StringJoiner sj = new StringJoiner(", ");
        for (LottoNumber lottoNumber : lotto) {
            sj.add(lottoNumber.getLottoNumber()+"");
        }
        System.out.println(sj);
        System.out.println("]");
    }
}
