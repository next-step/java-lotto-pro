package lotto;

import lotto.win.DefaultWinPolicy;
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

    public static Lotto from(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers, new DefaultWinPolicy());
    }

    public boolean isWin(LottoNumbers winningNumbers) {
        int matchCount = this.lottoNumbers.matches(winningNumbers);
        return winPolicy.isWin(matchCount);
    }

    public int matches(LottoNumbers winningNumbers) {
        return this.lottoNumbers.matches(winningNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
