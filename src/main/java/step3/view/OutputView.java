package step3.view;

import step3.domain.LottoResult;
import step3.domain.Lottos;

public class OutputView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult);
    }
}
