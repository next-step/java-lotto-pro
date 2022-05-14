package lotto.domain;

import lotto.constants.ErrorMessage;

import java.util.List;

public class LottoTickets {
    private final List<LottoNumbers> lottoTickets;

    public LottoTickets(List<LottoNumbers> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EMPTY_LOTTO);
        }
        this.lottoTickets = lottoTickets;
    }

    public LottoWinningRanks match(LottoNumbers winningNumbers) {
        LottoWinningRanks lottoWinningRanks = new LottoWinningRanks();
        lottoTickets.forEach(lottoNumbers -> {
            lottoWinningRanks.addWinningRank(lottoNumbers.rank(winningNumbers));
        });
        return lottoWinningRanks;
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
