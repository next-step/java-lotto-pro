package lotto_auto.model;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    public Lotto(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public LottoRank matches(WinningLotto from) {
        int count = this.lottoNumbers.countSameLottoNumber(from.getLotto().getLottoNumbers());
        return LottoRank.getLottoRuleFromMatchedCount(count, this.isContain(from.getBonusBall()));
    }

    private boolean isContain(LottoNumber number) {
        return lottoNumbers.isContain(number);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

}
