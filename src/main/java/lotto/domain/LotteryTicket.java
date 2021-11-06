package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LotteryTicket {
    private final List<LottoNumbers> lottoNumbersList;

    public LotteryTicket(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public int size() {
        return lottoNumbersList.size();
    }

    public void writeRecord(Record record, LottoNumbers winningNumber) {
        for (LottoNumbers numbers : lottoNumbersList) {
            Rank rank = numbers.getRank(winningNumber);
            record.increaseMatchedCount(rank);
        }
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(lottoNumbersList, that.lottoNumbersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbersList);
    }
}
