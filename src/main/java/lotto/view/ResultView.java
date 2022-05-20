package lotto.view;

import lotto.domain.LottoRank;
import lotto.dto.LottoResponse;

import java.util.Map;

public class ResultView {

    private static final String PURCHASE_LOTTO_TICKET_COUNT_MESSAGE = "%d개 구매했습니다.";
    private static final String RANK_BY_MONEY_AND_COUNT_MESSAGE = "%d개 일치 (%d원) %d개";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String LOTTO_STATISTICS = "\n당첨 통계\n---------";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void outPutPurchaseHistory(final LottoResponse.PurchasedLottoResultDto response) {
        outputPurchasedTicketCount(response);
        outputPurchasedTicket(response);
    }

    public void outPutLottoResult(LottoResponse.LottoConfirmResult response) {
        Map<LottoRank, Integer> rankCount = response.getRankCount();
        outputRankCount(rankCount);
        outputYield(response);
    }

    private void outputPurchasedTicketCount(LottoResponse.PurchasedLottoResultDto response) {
        System.out.println(String.format(PURCHASE_LOTTO_TICKET_COUNT_MESSAGE, response.getLottoCount()));
    }

    private void outputPurchasedTicket(LottoResponse.PurchasedLottoResultDto response) {
        response.getLottoDtos()
                .forEach(System.out::println);
        System.out.println();
    }

    private void outputRankCount(final Map<LottoRank, Integer> rankCount) {
        System.out.println(LOTTO_STATISTICS);
        for (LottoRank rank : LottoRank.reverse()) {
            System.out.println(String.format(RANK_BY_MONEY_AND_COUNT_MESSAGE, rank.getCountOfMatch(),
                    rank.getWinningMoney(), rankCount.get(rank)));
        }
    }

    private void outputYield(LottoResponse.LottoConfirmResult response) {
        double yield = response.getYield();

        System.out.print(String.format(TOTAL_YIELD_MESSAGE, yield));

        if (yield < 1) {
            System.out.println(LOSS_MESSAGE);
        }
    }
}
