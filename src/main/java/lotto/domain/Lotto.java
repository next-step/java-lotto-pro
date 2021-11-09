package lotto.domain;

import lotto.utils.RandomGeneratorUtils;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private WinningRank winningRank;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto buyAuto() {
        return new Lotto(LottoNumbers.valueOf(RandomGeneratorUtils.makeRandomNumbers()));
    }

    public static Lotto buyManual(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public WinningRank getWinningRank() {
        return winningRank;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public void judgeRank(WinningLotto winningLotto) {
        this.winningRank = WinningRank.resultRank(lottoNumbers.countMatchNumber(winningLotto.getWinningNumbers()), lottoNumbers.isMatchBonus(winningLotto.getBonus()));
    }

}
