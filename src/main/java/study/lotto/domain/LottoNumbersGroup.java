package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersGroup {

    private final List<LottoNumbers> lottoNumbersGroup;

    private LottoNumbers winningLottoNumbers;
    private LottoNumber bonusBall;

    public LottoNumbersGroup(Money money) {
        lottoNumbersGroup = new ArrayList<>();
        for(int i = 0; i < money.getPurchaseCount(); i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            lottoNumbersGroup.add(lottoNumbers);
        }
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersGroup;
    }

    public void setWinningLottoNumbers(LottoNumbers winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public void setBonusBall(LottoNumber bonusBall) {
        this.bonusBall = bonusBall;
    }

    public LottoNumbers getWinningLottoNumbers() {
        return this.winningLottoNumbers;
    }

    public LottoNumber getBonusBall() {
        return this.bonusBall;
    }
}
