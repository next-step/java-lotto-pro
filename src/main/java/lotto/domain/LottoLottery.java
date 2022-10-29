package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.OutputView;

public class LottoLottery {
    private final List<LottoNumbers> lottoLottery;

    private LottoLottery(List<LottoNumbers> lottoLottery) {
        this.lottoLottery = lottoLottery;
    }

    public static LottoLottery of(LottoQuantity lottoQuantity, LottoNumberGenerator lottoNumberGenerator) {
        List<LottoNumbers> lottoLottery = new ArrayList<>();
        for (int i = 0; i < lottoQuantity.getQuantity(); i++) {
            lottoLottery.add(LottoNumbers.of(lottoNumberGenerator));
        }
        return new LottoLottery(lottoLottery);
    }

    public WinningRanks checkWinningRank(WinningNumbers winningNumbers) {
        return WinningRanks.of(this.lottoLottery.stream()
                .map(winningNumbers::checkWinningRank)
                .collect(Collectors.toList()));
    }

    public String lotteryHistory() {
        List<String> historys = new ArrayList<>();
        for (LottoNumbers lottoNumbers : this.lottoLottery) {
            historys.add(lottoNumbers.history());
        }
        return String.join(OutputView.NEWLINE_DELIMITER, historys);
    }
}
