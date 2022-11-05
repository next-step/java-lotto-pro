package step3.domain;

import java.util.List;
import java.util.Objects;

public class WinningBonusNumber {
    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningBonusNumber(String winningNumbers, String bonusNumber) {
        this.winningNumber = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public List<LottoNumber> getWinningNumber() {
        return winningNumber.getWinningNumbers();
    }

    public boolean checkBonusNumber(Lotto lottoNumbers) {
        return lottoNumbers.matchNumber(bonusNumber);
    }

    public int getMatchCount(Lotto lotto) {
        return lotto.getMatchCount(winningNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningBonusNumber that = (WinningBonusNumber) o;
        return bonusNumber == that.bonusNumber && Objects.equals(winningNumber, that.winningNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber, bonusNumber);
    }
}
