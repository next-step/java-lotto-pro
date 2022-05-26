package lotto.view;

import lotto.domain.LottoRank;
import lotto.interfaces.dto.LottoResponse;

import java.util.Map;

public class ResultView {

    private static final String PURCHASE_LOTTO_TICKET_COUNT_MESSAGE = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String RANK_BY_MONEY_AND_COUNT_MESSAGE = "%d개 일치 (%d원) %d개";
    private static final String RANK_BY_MONEY_AND_COUNT_BONUS_MESSAGE = "%d개 일치, 보너스볼 일치(%d원)- %d개";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String LOTTO_STATISTICS = "\n당첨 통계\n---------";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void outPutPurchaseHistory(final LottoResponse.PurchasedLottoResultDto response) {
        outputPurchasedTicketCount(response);
        outputPurchasedTicket(response);
    }

    public void outPutLottoResult(final LottoResponse.LottoConfirmResult response) {
        Map<LottoRank, Integer> rankCount = response.getRankCount();
        outputRankCount(rankCount);
        outputYield(response);
    }

    private void outputPurchasedTicketCount(final LottoResponse.PurchasedLottoResultDto response) {
        System.out.println(String.format(PURCHASE_LOTTO_TICKET_COUNT_MESSAGE, response.getManualLottoCount(), response.getAutoLottoCount()));
    }

    private void outputPurchasedTicket(final LottoResponse.PurchasedLottoResultDto response) {
        response.getLottoDtos()
                .forEach(System.out::println);
        System.out.println();
    }

    private void outputRankCount(final Map<LottoRank, Integer> rankCounter) {
        System.out.println(LOTTO_STATISTICS);
        for (LottoRank rank : LottoRank.reverse()) {
            printRankByMoneyAndCount(rank, rankCounter.get(rank));
        }
    }

    private void outputYield(final LottoResponse.LottoConfirmResult response) {
        double yield = response.getYield();

        System.out.print(String.format(TOTAL_YIELD_MESSAGE, yield));

        if (yield < 1) {
            System.out.println(LOSS_MESSAGE);
        }
    }

    private void printRankByMoneyAndCount(LottoRank rank, int rankCount) {
        if (LottoRank.isSecond(rank)) {
            System.out.println(
                    String.format(RANK_BY_MONEY_AND_COUNT_BONUS_MESSAGE,
                            rank.getCountOfMatch(),
                            rank.getWinningMoney(),
                            rankCount));
            return;
        }

        System.out.println(String.format(
                RANK_BY_MONEY_AND_COUNT_MESSAGE, rank.getCountOfMatch(), rank.getWinningMoney(), rankCount)
        );
    }
}
