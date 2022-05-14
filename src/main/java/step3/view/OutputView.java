package step3.view;

import static step3.LottoConstant.FIVE_NUMBER_MATCH;
import static step3.LottoConstant.FOUR_NUMBER_MATCH;
import static step3.LottoConstant.LOTTOS_INFO_FORMAT;
import static step3.LottoConstant.LOTTO_FIVE_NUMBER_REWARD;
import static step3.LottoConstant.LOTTO_FOUR_NUMBER_REWARD;
import static step3.LottoConstant.LOTTO_PRICE;
import static step3.LottoConstant.LOTTO_SIX_NUMBER_REWARD;
import static step3.LottoConstant.LOTTO_THREE_NUMBER_REWARD;
import static step3.LottoConstant.OVERVIEW_FORMAT;
import static step3.LottoConstant.SIX_NUMBER_MATCH;
import static step3.LottoConstant.THREE_NUMBER_MATCH;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import step3.LottoConstant;

public class OutputView {

    private final Scanner scanOut;
    private final HashMap<Integer, Integer> rewardPerMatch = new HashMap<>();
    private final String isLoss = "손해";
    private final String isBenefit = "이득";

    public OutputView(Scanner scan) {
        this.scanOut = scan;
        init();
    }

    public void printOutput(HashMap<String, Integer> statistics, int lottoNumber) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        long reward = printOverview(statistics);
        printRewardRate(reward, lottoNumber);
    }

    private void printRewardRate(long reward, int lottoCount) {
        System.out.println(
            String.format(
                LottoConstant.REWARDRATE_FORMAT,
                reward / lottoCount * LOTTO_PRICE,
                checkBenefit(reward, lottoCount)
            ));
    }

    private String checkBenefit(long reward, int lottoCount) {
        if (lottoCount * LottoConstant.LOTTO_PRICE > reward) {
            return isLoss;
        }
        return isBenefit;
    }

    private long printOverview(HashMap<String, Integer> statistics) {
        long reward = 0;
        for (Entry<Integer, Integer> lottoRewardInfo : rewardPerMatch.entrySet()) {
            reward += printOverViewPerEntry(lottoRewardInfo.getKey(), lottoRewardInfo.getValue(), statistics);
        }
        return reward;
    }

    private long printOverViewPerEntry(int matchCount, int matchReward, HashMap<String, Integer> statistics) {
        System.out.println(String.format(OVERVIEW_FORMAT, matchCount, matchReward, statistics.get(matchCount)));
        return matchReward * statistics.get(matchCount);
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
