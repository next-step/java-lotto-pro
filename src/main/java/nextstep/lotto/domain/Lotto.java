package nextstep.lotto.domain;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Integer matchWithPurchaseLottoCount(Lotto purchaseLotto) {
        int initialMatchCount = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            if (purchaseLotto.lottoNumbers.isContains(lottoNumber)) {
                initialMatchCount += 1;
            }
        }

        return initialMatchCount;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }


}
