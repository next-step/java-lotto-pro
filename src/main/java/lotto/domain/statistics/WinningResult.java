package lotto.domain.statistics;

import lotto.domain.lotto.LottoTicket;

public class WinningResult {

    private final WinningNumbers winningNumbers;

    public WinningResult(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int matchCount(LottoTicket lottoTicket) {
        return (int) lottoTicket.getLottoNumbers().stream()
                .filter(winningNumbers::matchNumber)
                .count();
    }
}
