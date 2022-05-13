package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoRanks {
    private final List<LottoRank> lottoRanks;

    private LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public static LottoRanks of(List<LottoRank> lottoRanks) {
        return new LottoRanks(lottoRanks);
    }

    public Map<LottoRank, Long> resultLottoRanks() {
        return lottoRanks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Long totalCashPrize() {
        return lottoRanks.stream()
                .mapToLong(LottoRank::getCashPrize)
                .sum();
    }
}
