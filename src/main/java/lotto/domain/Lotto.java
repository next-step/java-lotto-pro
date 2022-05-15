package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_MONEY = 1000;

    private final LottoNumbers lottoNumbers;

    private Lotto() {
        this(LottoNumbers.autoLottoNumbers());
    }

    public static Lotto createAutoLotto() {
        return new Lotto(LottoNumbers.autoLottoNumbers());
    }

    public static Lotto createCustomLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private Lotto(List<Integer> lottoNumbers) {
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
