package lotto.domain;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    public static final int LOTTO_MONEY = 1000;

    public Lotto() {
        this(LottoNumbers.autoLottoNumbers());
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public LottoRank match(Lotto winLotto) {
        return LottoRank.reword(lottoNumbers.matchCount(winLotto.lottoNumbers));
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
