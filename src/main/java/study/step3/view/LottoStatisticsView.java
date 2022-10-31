package study.step3.view;

import study.step3.domain.lotto.LottoRank;
import study.step3.domain.lotto.Money;
import study.step3.domain.lottostatistics.LottoRateOfReturn;
import study.step3.domain.lottostatistics.LottoStatistics;
import study.step3.message.LottoMessage;

import java.util.Arrays;

public class LottoStatisticsView {

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        StringBuilder printer = new StringBuilder();
        printer.append("당첨 통계\n")
                .append("---------\n");
        appendCountOfAllRanks(lottoStatistics, printer);
        appendRateOfReturn(lottoStatistics, printer);
        ResultView.output(printer);
    }

    private static void appendCountOfAllRanks(LottoStatistics lottoStatistics, StringBuilder printer) {
        Arrays.stream(LottoRank.values())
                .filter(LottoRank::getWinningMoney)
                .sorted((o1, o2) -> (int) (o1.matchCount() - o2.matchCount()))
                .forEach(rank -> appendCountOfRank(rank, lottoStatistics, printer));
    }

    private static void appendCountOfRank(LottoRank rank, LottoStatistics lottoStatistics, StringBuilder printer) {
        Money winningMoney = rank.winningMoney();
        printer.append(
                String.format(LottoMessage.OUTPUT_COUNTS_OF_ALL_RANKS_FORMAT.message(),
                        rank.matchCount(),
                        winningMoney.money(),
                        lottoStatistics.findLottoRankCount(rank))
        );
    }

    private static void appendRateOfReturn(LottoStatistics lottoStatistics, StringBuilder printer) {
        LottoRateOfReturn rateOfReturn = lottoStatistics.calculateRateOfReturn();
        printer.append(
                String.format(LottoMessage.OUTPUT_RATE_OF_RETURN_FORMAT.message(),
                        rateOfReturn.rate(),
                        rateOfReturn.result())
        );
    }
}
