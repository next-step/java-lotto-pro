package lotto.domain;

import java.util.List;

import lotto.utils.RandomGeneratorUtils;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private WinningRank winningRank;

    private Lotto(List<Integer> numbers) {
        this.lottoNumbers = LottoNumbers.valueOf(numbers);
    }

    public static Lotto buyAuto() {
        return new Lotto(RandomGeneratorUtils.makeRandomNumbers());
    }

    public static Lotto buyManual(List<Integer> numbers) {
        return new Lotto(numbers);
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
