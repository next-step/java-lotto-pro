package step3.domain;

import java.util.List;
import java.util.Objects;
import step3.ValidationUtils;

public class WinningBonusNumber {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningBonusNumber(String winningNumbers, String bonusNumber) {
        this.winningNumber = new Lotto(winningNumbers);
        this.bonusNumber = ValidationUtils.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber.getWinningNumbers();
    }

    public boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
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
        return Objects.equals(winningNumber, that.winningNumber) && Objects.equals(bonusNumber, that.bonusNumber);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(winningNumber, bonusNumber);
    }

}
