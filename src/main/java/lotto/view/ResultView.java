package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.enums.LottoRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.common.Messages.*;

public class ResultView {

    public static void purchasesCountMessage(int purchasesCount) {
        System.out.printf((PURCHASES_COUNT_MESSAGE) + "%n", purchasesCount);
    }

    public static void lottoRandomMessage(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void lottoGameResultMessage(List<LottoRank> lottoRanks) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPARATOR);

        Arrays.stream(LottoRank.values()).forEach(
                lottoRank -> System.out.printf(
                        (GAME_RESULT_MESSAGE) + "%n",
                        lottoRank.getMatchingCount(),
                        lottoRank.getPrizeMoney(),
                        Collections.frequency(lottoRanks, lottoRank)
                )
        );
    }
}
