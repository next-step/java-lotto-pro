package lotto.view;

import static lotto.domain.Prize.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

public class ResultView {

    public static void printPurchaseNumbers(List<LottoNumbers> purchaseLottoList) {
        for (LottoNumbers lottoNumbers : purchaseLottoList) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public static void printResult(LottoResult lotto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Prize> prizes = Arrays.stream(values())
            .filter(prize -> prize != NOTHING)
            .sorted(Comparator.comparingInt(Prize::getMatchCount))
            .collect(Collectors.toList());
        for (Prize prize : prizes) {
            System.out.println(String.format("%s- %d개", prize, lotto.getCount(prize)));
        }
        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", lotto.calculateRateOfReturn()));
    }
}
