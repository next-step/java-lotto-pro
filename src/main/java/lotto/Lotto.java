package lotto;

import lotto.win.WinPolicy;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    private final WinPolicy winPolicy;

    private Lotto(LottoNumbers lottoNumbers, WinPolicy winPolicy) {
        this.lottoNumbers = lottoNumbers;
        this.winPolicy = winPolicy;
    }

    public static Lotto of(LottoNumbers lottoNumbers, WinPolicy winPolicy) {
        return new Lotto(lottoNumbers, winPolicy);
    }

    public boolean isWin(LottoNumbers winningNumbers) {
        int matchCount = this.lottoNumbers.matches(winningNumbers);
        return winPolicy.isWin(matchCount);
    }
}
