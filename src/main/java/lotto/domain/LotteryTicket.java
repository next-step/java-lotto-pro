package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LotteryTicket {
    private final List<LottoNumbers> lottoNumbersList;

    public LotteryTicket(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public LotteryTicket(String[] textLottoNumbers) {
        this(getLottoNumbers(textLottoNumbers));
    }

    private static List<LottoNumbers> getLottoNumbers(String[] textLottoNumbers) {
        return Arrays.stream(textLottoNumbers)
                .map(LottoNumbers::of)
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoNumbersList.size();
    }

    public void writeRecord(Record record, WinningLottoNumbers winningNumber) {
        for (LottoNumbers numbers : lottoNumbersList) {
            Rank rank = winningNumber.getRank(numbers);
            record.increaseMatchedCount(rank);
        }
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }

    public LotteryTicket merge(LotteryTicket addedLotteryTicket) {
        List<LottoNumbers> newList = new ArrayList<>(lottoNumbersList);
        newList.addAll(addedLotteryTicket.lottoNumbersList);
        return new LotteryTicket(newList);
    }

    public int getManualLottoSize() {
        return (int) lottoNumbersList.stream()
                .filter(LottoNumbers::isManual)
                .count();
    }

    public int getAutoLottoSize() {
        return size() - getManualLottoSize();
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
