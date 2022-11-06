package lotto.model.winning.numbers;

import lotto.model.lotto.ticket.LottoNumber;

import java.util.List;

public class WinningNumbers {
    private final List<LottoNumber> lottoNumbers;

    public WinningNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}
