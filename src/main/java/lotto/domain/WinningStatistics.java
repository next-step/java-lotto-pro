package lotto.domain;

import lotto.enums.WinningRank;
import lotto.utils.LottoWinningRankMatcher;

public class WinningStatistics {
    private static final int PERCENT_CALCULATE_CRITERIA = 100;
    private final LottoTicket lottoTicket;
    private final Money money;
    private final LottoNumbers lastWinningLottoNumbers;
    private final LottoNumber bonusBallNumber;
    private final WinningRecord winningRecord;

    private WinningStatistics(LottoTicket lottoTicket, Money money, LottoNumbers lastWinningLottoNumbers, LottoNumber bonusBallNumber) {
        this.lottoTicket = lottoTicket;
        this.money = money;
        this.lastWinningLottoNumbers = lastWinningLottoNumbers;
        this.bonusBallNumber = bonusBallNumber;
        this.winningRecord = WinningRecord.createEmpty();
    }

    public static WinningStatistics of(LottoTicket lottoTicket, Money money, LottoNumbers lastWinningLottoNumbers, LottoNumber bonusBallNumber) {
        return new WinningStatistics(lottoTicket, money, lastWinningLottoNumbers, bonusBallNumber);
    }

    public void statistics() {
        for (LottoNumbers lottoNumbers : lottoTicket.getReadOnlyLottoNumbers()) {
            WinningRank winningRank = LottoWinningRankMatcher.match(this.lastWinningLottoNumbers, this.bonusBallNumber, lottoNumbers);
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
