package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoLottery {
    private static final String NEWLINE_DELIMITER = "\n";

    private final List<LottoNumbers> lottoLottery;

    public LottoLottery(List<LottoNumbers> lottoLottery) {
        this.lottoLottery = lottoLottery;
    }

    public static LottoLottery of(LottoPurchaseQuantity lottoPurchaseQuantity, LottoNumberGenerator lottoNumberGenerator) {
        return lottoPurchaseQuantity.toLottoLottery(lottoNumberGenerator);
    }

    public WinningRanks matchWinningRank(WinningNumbers winningNumbers) {
        return WinningRanks.of(this.lottoLottery.stream()
                .map(winningNumbers::matchWinningRank)
                .collect(Collectors.toList()));
    }

    public String lotteryHistory() {
        List<String> histories = new ArrayList<>();
        for (LottoNumbers lottoNumbers : this.lottoLottery) {
            histories.add(lottoNumbers.history());
        }
        return String.join(NEWLINE_DELIMITER, histories);
    }

    public void addLottery(LottoLottery autoLottery) {
        this.lottoLottery.addAll(autoLottery.lottoLottery);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoLottery that = (LottoLottery) o;
        return Objects.equals(lottoLottery, that.lottoLottery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoLottery);
    }
}
