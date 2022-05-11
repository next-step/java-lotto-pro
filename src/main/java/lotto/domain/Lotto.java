package lotto.domain;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(LottoNumbers lottoNumbers){
        return new Lotto(lottoNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }
}
