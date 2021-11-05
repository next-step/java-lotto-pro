package lotto.domain;

public class Winning {


    private final LottoNumbers winningNumbers;

    public Winning(final String input) {
        this.winningNumbers = LottoNumbers.fromString(input);
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }
}
