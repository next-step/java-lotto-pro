package study.lotto.domain;

import java.util.List;

public class LottoNumbersGroup {

    private final List<LottoNumbers> lottoNumbersGroup;

    private LottoNumbers lastLottoNumbers;
    private LottoNumber bonusBall;

    public LottoNumbersGroup(List<LottoNumbers> lottoNumbersGroup) {
        this.lottoNumbersGroup = lottoNumbersGroup;
    }

    public LottoNumbersGroup(List<LottoNumbers> lottoNumbersGroup, LottoNumbers lastLottoNumbers, LottoNumber bonusBall) {
        this.lottoNumbersGroup = lottoNumbersGroup;
        this.lastLottoNumbers = lastLottoNumbers;
        this.bonusBall = bonusBall;
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersGroup;
    }

    public void setLastLastLottoNumbers(LottoNumbers lastLottoNumbers) {
        this.lastLottoNumbers = lastLottoNumbers;
    }

    public void setBonusBall(LottoNumber bonusBall) {
        this.bonusBall = bonusBall;
    }

    public LottoNumbers getLastLottoNumbers() {
        return this.lastLottoNumbers;
    }

    public LottoNumber getBonusBall() {
        return this.bonusBall;
    }
}
