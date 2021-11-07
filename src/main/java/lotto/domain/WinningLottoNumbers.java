package lotto.domain;

import java.util.Objects;

public class WinningLottoNumbers {
    private final LottoNumbers winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLottoNumbers(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningLottoNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(LottoNumbers lottoNumbers) {
        int result = 0;
        for (LottoNumber number : lottoNumbers.getNumbers()) {
            result = getIncreasedNumberIfContains(winningNumbers, number, result);
        }
        return Rank.of(result);
    }

    private int getIncreasedNumberIfContains(LottoNumbers winningNumbers, LottoNumber number, int result) {
        if (winningNumbers.contains(number)) {
            return result + 1;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottoNumbers that = (WinningLottoNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
