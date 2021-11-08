package lotto.domain;

public class WinningLotto {
    private final LottoNumbers winningNumbers;
    private final Bonus bonus;

    private WinningLotto(LottoNumbers winningNumbers, Bonus bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public static WinningLotto of(LottoNumbers winningNumbers, Bonus bonus) {
        return new WinningLotto(winningNumbers, bonus);
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public Bonus getBonus() {
        return bonus;
    }

}
