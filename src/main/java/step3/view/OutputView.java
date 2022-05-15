package step3.view;

import static step3.LottoConstant.FIVE_NUMBER_MATCH;
import static step3.LottoConstant.FOUR_NUMBER_MATCH;
import static step3.LottoConstant.LOTTOS_INFO_FORMAT;
import static step3.LottoConstant.LOTTO_FIVE_NUMBER_REWARD;
import static step3.LottoConstant.LOTTO_FOUR_NUMBER_REWARD;
import static step3.LottoConstant.LOTTO_SIX_NUMBER_REWARD;
import static step3.LottoConstant.LOTTO_THREE_NUMBER_REWARD;
import static step3.LottoConstant.OVERVIEW_FORMAT;
import static step3.LottoConstant.SIX_NUMBER_MATCH;
import static step3.LottoConstant.THREE_NUMBER_MATCH;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import step3.LottoConstant;
import step3.constant.LottoReward;

public class OutputView {

    private final HashMap<Integer, Integer> rewardPerMatch = new HashMap<>();
    private final String isLoss = "손해";
    private final String isBenefit = "이득";

    public OutputView() {
        init();
    }

    public void printOutput(HashMap<String, Integer> statistics, int money) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        long reward = printOverview(statistics);
        printRewardRate(reward, money);
    }

    private void printRewardRate(long reward, int money) {
        System.out.println(
            String.format(
                LottoConstant.REWARDRATE_FORMAT,
                reward * 1.0 / money,
                checkBenefit(reward, money)
            ));
    }

    private String checkBenefit(long reward, int money) {
        if (money > reward) {
            return isLoss;
        }
        return isBenefit;
    }

    private long printOverview(HashMap<String, Integer> statistics) {
        long reward = 0;
        for (Entry<String, Integer> lottoMatchEntry : statistics.entrySet()) {
            reward += printOverViewPerEntry(LottoReward.valueOf(lottoMatchEntry.getKey()), lottoMatchEntry.getValue());
        }
        return reward;
    }

    private long printOverViewPerEntry(LottoReward lottoReward, int matchCount) {
        if (lottoReward.ordinal() < 3) {
            return 0;
        }
        System.out.println(String.format(OVERVIEW_FORMAT, matchCount, lottoReward.getReward(), matchCount));
        return lottoReward.getReward() * matchCount;
    }

    public void printLottoInfo(List<List<String>> lottoNumbers) {
        System.out.println(String.format(LOTTOS_INFO_FORMAT, lottoNumbers.size()));
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.println(lottoNumbers.get(i).toString());
        }
    }

    private void init() {
        rewardPerMatch.put(THREE_NUMBER_MATCH, LOTTO_THREE_NUMBER_REWARD);
        rewardPerMatch.put(FOUR_NUMBER_MATCH, LOTTO_FOUR_NUMBER_REWARD);
        rewardPerMatch.put(FIVE_NUMBER_MATCH, LOTTO_FIVE_NUMBER_REWARD);
        rewardPerMatch.put(SIX_NUMBER_MATCH, LOTTO_SIX_NUMBER_REWARD);
    }
}
