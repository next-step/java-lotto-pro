package step3.model;

import java.util.List;

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

    public boolean checkBonusNumber(List<Number> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
