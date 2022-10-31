package lotto.view;

import static lotto.domain.Rank.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class ResultView {

    public static void printPurchaseNumbers(List<LottoNumbers> lottoNumbersList, Integer manualCount) {
        System.out.println();
        System.out.println(
            String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount, lottoNumbersList.size() - manualCount));
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public static void printResult(LottoResult lotto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Rank> ranks = Arrays.stream(values())
            .filter(rank -> rank != MISS)
            .sorted(Comparator.comparingInt(Rank::getWinningMoney))
            .collect(Collectors.toList());
        for (Rank rank : ranks) {
            System.out.println(String.format("%s- %d개", rank, lotto.getCount(rank)));
        }
        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lotto.calculateRateOfReturn()));
    }
}
