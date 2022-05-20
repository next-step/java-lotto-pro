package lotto.domain;

import lotto.domain.error.LottoTicketsErrorCode;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTickets {

    private final List<LottoTicket> value;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        validateNullOrEmpty(lottoTickets);
        this.value = lottoTickets;
    }

    public LottoCount getLottoTicketsCount() {
        return new LottoCount(value.size());
    }

    public List<LottoTicket> getValue() {
        return Collections.unmodifiableList(value);
    }

    public LottoResult compareWinningLottoTicket(WinningLottoTicket winningLottoTicket) {
        LottoResult lottoResult = new LottoResult();

        for (LottoTicket lottoTicket : value) {
            lottoResult.countLottoRank(winningLottoTicket, lottoTicket);
        }

        return lottoResult;
    }

    private void validateNullOrEmpty(List<LottoTicket> lottoTickets) {
        if (Objects.isNull(lottoTickets) || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException(LottoTicketsErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
        }
    }
}
