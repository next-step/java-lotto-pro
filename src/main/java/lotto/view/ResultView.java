package lotto.view;

import java.util.List;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;

public class ResultView {

    public static void printPurchaseNumbers(List<LottoNumber> purchaseLottoList) {
        for (LottoNumber lottoNumber : purchaseLottoList) {
            System.out.println(lottoNumber);
        }
        System.out.println();
    }

    public static void printStat(LottoResult lotto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        // for (WinPrize winPrize : WinPrize.values()) {
        //     System.out.println(String.format("%s- %d개", winPrize, lotto.matchesCount(winPrize.getMatchCount())));
        // }
        // System.out.println(String.format("총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", ));
    }
}
