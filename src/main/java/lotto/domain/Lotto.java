package lotto.domain;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this(LottoNumbers.autoLottoNumbers());
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank match(Lotto winLotto) {
        return LottoRank.reword(lottoNumbers.matchCount(winLotto.lottoNumbers));
    }
}
