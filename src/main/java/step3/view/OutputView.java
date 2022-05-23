package step3.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import step3.domain.LottoElement;
import step3.enums.LottoReward;

public class OutputView {

    private static final String REWARD_RATE_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String LOTTOS_INFO_FORMAT = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    private static final String OVERVIEW_INIT_MESSAGE = "\n당첨 통계\n---------";
    private static final String IS_LOSS = "손해";
    private static final String IS_BENEFIT = "이득";
    private Map<LottoReward, String> LOTTO_OVERVIEW_FORMAT = new HashMap<>();


    public OutputView() {
        initOverviewMap();
    }

    public void printOutput(Map<LottoReward, Integer> statistics,
        Map<String, String> lottoIncomeResult) {
        System.out.println(OutputView.OVERVIEW_INIT_MESSAGE);
        for (LottoReward lottoReward : LOTTO_OVERVIEW_FORMAT.keySet()) {
            int matchCount = statistics.get(lottoReward);
            printOverViewPerEntry(lottoReward, matchCount);
        }
        printRewardRate(lottoIncomeResult.get("profitRate"), lottoIncomeResult.get("isBenefit"));
    }

    private void printRewardRate(String profitRate, String isBenefit) {
        System.out.println(
            String.format(OutputView.REWARD_RATE_FORMAT, Float.valueOf(profitRate), isBenefit));
    }


    private void printOverViewPerEntry(LottoReward lottoReward, int matchCount) {
        System.out.println(
            String.format(LOTTO_OVERVIEW_FORMAT.get(lottoReward), lottoReward.getMatchCount(),
                lottoReward.getReward(), matchCount));
    }


    public void printLottoInfo(List<List<LottoElement>> lottoTickets, int manualTicketCount,
        int randomTicketCount) {
        System.out.println(
            String.format(OutputView.LOTTOS_INFO_FORMAT, manualTicketCount, randomTicketCount));
        for (List<LottoElement> lottoTicketNumbers : lottoTickets) {
            System.out.println(lottoTicketNumbers.toString());
        }
    }

    private void initOverviewMap() {
        LOTTO_OVERVIEW_FORMAT = new LinkedHashMap<>();
        LOTTO_OVERVIEW_FORMAT.put(LottoReward.THREE, "%s개 일치 (%s원)- %s개");
        LOTTO_OVERVIEW_FORMAT.put(LottoReward.FOUR, "%s개 일치 (%s원)- %s개");
        LOTTO_OVERVIEW_FORMAT.put(LottoReward.FIVE, "%s개 일치 (%s원)- %s개");
        LOTTO_OVERVIEW_FORMAT.put(LottoReward.FIVE_BONUS, "%s개 일치, 보너스 볼 일치 (%s원)- %s개");
        LOTTO_OVERVIEW_FORMAT.put(LottoReward.SIX, "%s개 일치 (%s원)- %s개");
    }
}

