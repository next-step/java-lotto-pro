package lotto.model.winning.numbers;

import lotto.model.lotto.ticket.LottoNumber;

import java.util.List;

public class WinningNumbers {
    private final List<LottoNumber> lottoNumbers;
    private LottoNumber bonus;

    public WinningNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public WinningNumbers(WinningNumbers winningNumbers) {
        this.lottoNumbers = winningNumbers.lottoNumbers;
        this.bonus = winningNumbers.bonus;
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    public void setBonus(LottoNumber bonus) {
        this.bonus = bonus;
    }

    public LottoNumber bonus() {
        return bonus;
    }
}
