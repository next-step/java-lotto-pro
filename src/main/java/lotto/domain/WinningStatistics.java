package lotto.domain;

import lotto.enums.WinningRank;
import lotto.utils.LottoWinningRankMatcher;

public class WinningStatistics {
    private static final int PERCENT_CALCULATE_CRITERIA = 100;
    private final Lottos lottos;
    private final LottoNumbers lastWinningLottoNumbers;
    private final WinningRecord winningRecord;
    private final Money money;

    private WinningStatistics(Lottos lottos, LottoNumbers lastWinningLottoNumbers, Money money) {
        this.lottos = lottos;
        this.lastWinningLottoNumbers = lastWinningLottoNumbers;
        this.money = money;
        this.winningRecord = WinningRecord.createEmpty();
    }

    public static WinningStatistics of(Lottos lottos, LottoNumbers lastWinningLottoNumbers, Money money) {
        return new WinningStatistics(lottos, lastWinningLottoNumbers, money);
    }

    public void statistics() {
        for (Lotto lotto : lottos.getReadOnlyLottos()) {
            WinningRank winningRank = LottoWinningRankMatcher.match(lastWinningLottoNumbers,
                lotto.getLottoNumbers());

            this.winningRecord.recording(winningRank);
        }
    }

    public WinningRecord getWinningRecord() {
        return this.winningRecord;
    }

    public double getTotalProfitRate() {
        double totalPrizeMoney = this.winningRecord.getTotalPrizeMoney();
        double investedMoney = this.money.getMoney();
        double rate = totalPrizeMoney / investedMoney;
        return Math.round(rate * PERCENT_CALCULATE_CRITERIA) / (double) PERCENT_CALCULATE_CRITERIA;
    }
}
