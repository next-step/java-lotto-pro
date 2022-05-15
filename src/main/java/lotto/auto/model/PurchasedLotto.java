package lotto.auto.model;

import lotto.auto.type.LottoGeneratorType;

public class PurchasedLotto {

    private LottoGeneratorType lottoGeneratorType;
    private LottoNumbers lottoNumbers;

    private PurchasedLotto() {
        generatedAutoLottoNumber();
    }

    private void generatedAutoLottoNumber() {
        this.lottoNumbers = new LottoNumbers(LottoAutoFactory.randomLottoNumberByLottoSize());
        this.lottoGeneratorType = LottoGeneratorType.AUTO;
    }

    public static PurchasedLotto createAuto() {
        return new PurchasedLotto();
    }

    public LottoGeneratorType getLottoGeneratorType() {
        return lottoGeneratorType;
    }

}
