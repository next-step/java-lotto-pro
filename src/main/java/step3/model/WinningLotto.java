package step3.model;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final Number bonusNumber;

    public WinningLotto(Lotto winningNumbers, Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(Number lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }
}
