package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.LottoRank;

public class PurchasedLottoTickets {
    private final List<LottoNumbers> lottoNumbers;

    private PurchasedLottoTickets(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static PurchasedLottoTickets from(List<LottoNumbers> lottoNumbers) {
        return new PurchasedLottoTickets(lottoNumbers);
    }

    public int purchasedTicketsCount() {
        return this.lottoNumbers.size();
    }

    public LottoWinningResults checkWinningLotto(WinningLotto winningLotto) {
        List<LottoRank> ranks = lottoNumbers.stream().
                map(winningLotto::match).
                collect(Collectors.toList());
        return LottoWinningResults.from(ranks);
    }

    public PurchasedLottoTickets merge(List<LottoNumbers> manualLottoNumbersList) {
        List<LottoNumbers> mergedList = new ArrayList<>();
        mergedList.addAll(manualLottoNumbersList);
        mergedList.addAll(this.lottoNumbers);
        return PurchasedLottoTickets.from(mergedList);
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().
                map(LottoNumbers::toString).
                collect(Collectors.joining("\n"));
    }
}
