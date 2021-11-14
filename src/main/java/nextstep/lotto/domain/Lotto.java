package nextstep.lotto.domain;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Integer matchWithPurchaseLottoCount(Lotto purchaseLotto, BonusBall bonusBall) {
        int initialMatchCount = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            initialMatchCount += addContainsLottoNumberCount(lottoNumber, purchaseLotto);
        }

        if (purchaseLotto.lottoNumbers.isBonusBallContains(bonusBall)) {
            initialMatchCount += 1;
        }

        return initialMatchCount;
    }

    public Integer addContainsLottoNumberCount(LottoNumber lottoNumber, Lotto purchaseLotto) {
        if (purchaseLotto.lottoNumbers.isContains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public static Boolean isContainsLottoNumber(LottoNumber lottoNumber, Lotto purchaseLotto) {
        if (purchaseLotto.lottoNumbers.isContains(lottoNumber)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
