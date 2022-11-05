package lotto.model.lotto.ticket;

import lotto.model.winning.numbers.WinningNumbers;

import java.util.List;

public class LottoTicket {
    protected final List<LottoNumber> lottoNumbers;
    private int count = 0;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int numberMatch(WinningNumbers winningNumbers) {
        count = 0;
        final List<LottoNumber> lottoNumbersOfWinningNumbers = winningNumbers.lottoNumbers();
        for (LottoNumber winningNumber : lottoNumbersOfWinningNumbers) {
            incrementCountIfLottoNumberMatch(winningNumber);
        }
        return count;
    }

    private void incrementCountIfLottoNumberMatch(LottoNumber winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            count += 1;
        }
    }
}
