package step3.model;

public class WinningLotto {
    private final Lotto winningNumbers;

    public WinningLotto(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public boolean contains(Number lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }
}
