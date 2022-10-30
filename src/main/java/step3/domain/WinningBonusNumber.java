package step3.domain;

import step3.ValidationUtils;

import java.util.List;
import java.util.Objects;

public class WinningBonusNumber {
    private final WinningNumber winningNumber;
    private final int bonusNumber;
    
    public WinningBonusNumber(WinningNumber winningNumber, String bonusNumber) {
        this.winningNumber = winningNumber;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningBonusNumber that = (WinningBonusNumber) o;
        return Objects.equals(winningNumber, that.winningNumber) && Objects.equals(bonusNumber, that.bonusNumber);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(winningNumber, bonusNumber);
    }

}
