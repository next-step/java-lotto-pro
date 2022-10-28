package lotto.domain;

public class WinningNumbers {
    private LottoNumbers winningNumbers;

    private WinningNumbers(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers of(String input) {
        return new WinningNumbers(LottoNumbers.of(new ManualNumberGenerator(input)));
    }

    public WinningRank checkWinningRank(LottoNumbers lottoNumbers) {
        return WinningRank.valueOf(lottoNumbers.containCount(winningNumbers));
    }
}