package lotto_auto.model;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    public Lotto(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public LottoRank matches(WinningLotto from) {
        int count = this.lottoNumbers.countSameLottoNumber(from);
        return LottoRank.getLottoRuleFromMatchedCount(count, isContain(from.getBonusBall()));
    }

    public boolean isContain(LottoNumber number) {
        return lottoNumbers.isContain(number);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

}
