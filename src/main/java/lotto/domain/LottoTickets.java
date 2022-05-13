package lotto.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lotto.enums.LottoRank;

public class LottoTickets {
    private List<LottoNumbers> lottoNumbers;

    private LottoTickets(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTickets from(List<LottoNumbers> lottoNumbers) {
        return new LottoTickets(lottoNumbers);
    }

    public int purchasedTicketsCount() {
        return this.lottoNumbers.size();
    }

    public String purchasedTicketNumberString() {
        return lottoNumbers.stream().
                map(LottoNumbers::numberStrings).
                collect(Collectors.joining("\n"));
    }

    public LottoWinningResults match(LottoNumbers winningLottoNumbers) {
        List<LottoRank> resultRanks = lottoNumbers.stream().
                map(ln -> ln.hitCounts(winningLottoNumbers)).
                map(LottoRank::valueOf).
                filter(LottoRank::isPrized).
                collect(Collectors.toList());
        return LottoWinningResults.from(resultRanks);
    }
}
