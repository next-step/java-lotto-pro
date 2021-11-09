package lotto.view;

import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.Lottos;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_WINNING_MESSAGE = "\n당첨 통계\n" + "---------\n";
    private static final String WINNING_COUNT_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String WINNING_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";
    private static final String TOTAL_REWARD_MESSAGE = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String LOSS_MESSAGE = "손해";
    private static final String PROFIT_MESSAGE = "이익이";

    private static final StringBuffer STRING_BUFFER = new StringBuffer();

    public void printLottoCount(int count) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, count));
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    public static void printLottoResult(LottoResult lottoResult) {
        winning(lottoResult);
        totalRewardRatio(lottoResult);
        System.out.println(STRING_BUFFER);
    }

    private static void winning(final LottoResult lottoResult) {
        STRING_BUFFER.append(LOTTO_WINNING_MESSAGE)
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.FIFTH.getMatchCount(), LottoRank.FIFTH.getMoney(), lottoResult.getResult(LottoRank.FIFTH)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.FOURTH.getMatchCount(), LottoRank.FOURTH.getMoney(), lottoResult.getResult(LottoRank.FOURTH)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.THIRD.getMatchCount(), LottoRank.THIRD.getMoney(), lottoResult.getResult(LottoRank.THIRD)))
                .append(String.format(WINNING_BONUS_MESSAGE, LottoRank.SECOND.getMatchCount(), LottoRank.SECOND.getMoney(), lottoResult.getResult(LottoRank.SECOND)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.FIRST.getMatchCount(), LottoRank.FIRST.getMoney(), lottoResult.getResult(LottoRank.FIRST)));
    }

    public static void totalRewardRatio(final LottoResult lottoResult) {
        STRING_BUFFER.append(String.format(TOTAL_REWARD_MESSAGE, lottoResult.rewardRatio(), lottoResult.rewardRatio() > 1 ? PROFIT_MESSAGE : LOSS_MESSAGE));
    }
}
