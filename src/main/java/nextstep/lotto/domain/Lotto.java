package nextstep.lotto.domain;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Integer matchWithPurchaseLottoCount(Lotto purchaseLotto, BonusBall bonusBall) {
        int initialMatchCount = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            if (purchaseLotto.lottoNumbers.isContains(lottoNumber)) {
                initialMatchCount += 1;
            }
        }

        if (purchaseLotto.lottoNumbers.isBonusBallContains(bonusBall)) {
            initialMatchCount += 1;
        }

        return initialMatchCount;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
