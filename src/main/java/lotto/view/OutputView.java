package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;

public class OutputView {

    private static final String LEFT_BRACKET = "[";

    private static final String RIGHT_BRACKET = "]";

    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private static final String BUY_LOTTO_COUNT_MESSAGE = "%d개 구매했습니다.";

    private static final String LOTTO_STATISTICS = "\n당첨 통계\n---------";

    private static final String RANK_MONEY_COUNT_MESSAGE = "%d개 일치 (%d원) %d개";

    private static final String RANK_MONEY_COUNT_BONUS_MESSAGE = "%d개 일치, 보너스볼 일치(%d원) %d개";

    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.2f입니다.";

    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final int LOSS_STANDARD = 1;

    public static void outputBuyLottosCount(final int buyLottoCount) {
        System.out.println(String.format(BUY_LOTTO_COUNT_MESSAGE, buyLottoCount));
    }

    public static void outputBuyLottos(final Lottos lottos) {
        for (Lotto lotto: lottos.getLottos()) {
            lottoNumberPrint(lotto);
        };
        System.out.println();
    }

    private static void lottoNumberPrint(final Lotto lotto) {
        StringBuilder builder = new StringBuilder();
        builder.append(LEFT_BRACKET);
        builder.append(lottoNumberString(lotto.getLottoNumbers()));
        builder.append(RIGHT_BRACKET);
        System.out.println(builder.toString());
    }

    private static String lottoNumberString(final List<LottoNumber> lottoNumbers) {
        StringBuilder builder = new StringBuilder();

        for (LottoNumber lottoNumber : lottoNumbers) {
            builder.append(builder.length() == 0 ? "" : LOTTO_NUMBER_DELIMITER);
            builder.append(lottoNumber.getLottoNumber());
        }

        return builder.toString();
    }

    public static void outputLottoRank(final Map<LottoRank, Integer> rankInfo) {
        System.out.println(LOTTO_STATISTICS);
        for (LottoRank lottoRank: LottoRank.reverse()) {
            lottoRankMoneyAndCount(rankInfo, lottoRank);
        }
    }

    private static void lottoRankMoneyAndCount(final Map<LottoRank, Integer> rankInfo, LottoRank lottoRank) {
        if (lottoRank.isMatchBonus()) {
            System.out.println(String.format(RANK_MONEY_COUNT_BONUS_MESSAGE,
                lottoRank.getCountMatch(), lottoRank.getWinningMoney(), rankInfo.get(lottoRank)));
            return;
        }
        System.out.println(String.format(RANK_MONEY_COUNT_MESSAGE,
            lottoRank.getCountMatch(), lottoRank.getWinningMoney(), rankInfo.get(lottoRank)));
    }

    public static void outputYield(double yield) {
        System.out.print(String.format(TOTAL_YIELD_MESSAGE, yield));
        if (yield < LOSS_STANDARD) {
            System.out.print(LOSS_MESSAGE);
        }
    }
}
