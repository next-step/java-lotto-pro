package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLottoTickets {
    private final List<LottoNumbers> lottoNumbers;

    private PurchasedLottoTickets(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static PurchasedLottoTickets from(List<LottoNumbers> lottoNumbers) {
        return new PurchasedLottoTickets(lottoNumbers);
    }

    public List<LottoNumbers> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int purchasedTicketsCount() {
        return this.lottoNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().
                map(LottoNumbers::toString).
                collect(Collectors.joining("\n"));
    }
}
