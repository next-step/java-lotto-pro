package step3.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import step3.domain.LottoElement;
import step3.domain.Money;
import step3.enums.LottoReward;

public class OutputView {


    private final int MATCH_COUNT_LIMIT = 3;
    private final String OVERVIEW_FORMAT = "%s개 일치 (%s원)- %s개";
    private final String REWARD_RATE_FORMAT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private final String LOTTOS_INFO_FORMAT = "%s개를 구매했습니다.";
    private final String OVERVIEW_INIT_MESSAGE = "\n당첨 통계\n---------";

    public OutputView() {
    }

    public void printOutput(HashMap<String, Integer> statistics, Money money) {
        System.out.println(OVERVIEW_INIT_MESSAGE);

        long reward = printOverview(statistics);
        printRewardRate(reward, money);
    }

    private void printRewardRate(long reward, Money money) {
        System.out.println(String.format(REWARD_RATE_FORMAT, money.getProfitRate(reward), money.isBenefit(reward)));
    }

    private long printOverview(HashMap<String, Integer> statistics) {
        long reward = 0;
        for (Entry<String, Integer> lottoMatchEntry : statistics.entrySet()) {
            reward += printOverViewPerEntry(LottoReward.valueOf(lottoMatchEntry.getKey()), lottoMatchEntry.getValue());
        }
        return reward;
    }

    private long printOverViewPerEntry(LottoReward lottoReward, int matchCount) {
        if (lottoReward.ordinal() < MATCH_COUNT_LIMIT) {
            return 0;
        }
        System.out.println(String.format(OVERVIEW_FORMAT, lottoReward.getMatchCount(), lottoReward.getReward(), matchCount));
        return lottoReward.getReward() * matchCount;
    }

    public void printLottoInfo(List<List<LottoElement>> lottoNumbers) {
        System.out.println(String.format(LOTTOS_INFO_FORMAT, lottoNumbers.size()));
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i).toString());
        }
    }
}
