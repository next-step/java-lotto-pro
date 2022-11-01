package lotto.model.lotto.ticket;

import lotto.model.winning.numbers.WinningNumbers;

import java.util.List;

public class LottoTicket {
    protected final List<LottoNumber> lottoNumbers;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumbers = lottoNumberGenerator.generate();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int numberMatch(WinningNumbers winningNumbers) {
        int count = 0;
        final List<LottoNumber> lottoNumbersOfWinningNumbers = winningNumbers.lottoNumbers();
        for (LottoNumber winningNumber : lottoNumbersOfWinningNumbers) {
            count = incrementCountIfLottoNumberMatch(count, winningNumber);
        }
        return count;
    }

    private int incrementCountIfLottoNumberMatch(int count, LottoNumber winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return count + 1;
        }
        return count;
    }
}
