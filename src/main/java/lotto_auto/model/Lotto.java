package lotto_auto.model;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    public Lotto(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public LottoRank matches(Lotto from) {
        int count = this.lottoNumbers.countSameLottoNumber(from.lottoNumbers);
        return LottoRank.getLottoRuleFromMatchedCount(count);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
