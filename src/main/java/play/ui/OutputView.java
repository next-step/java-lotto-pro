package play.ui;

import play.domain.Lotto;
import play.domain.LottoResult;
import play.domain.Lottos;

public class OutputView {
    public static void printCompletePurchaseLotto(Lottos lottos) {
        System.out.println(lottos.getLottoList().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResultHead() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printLottoResult(LottoResult lottoResult) {
        for (String result : lottoResult.convertResultMapToString()) {
            System.out.println(result);
        }
        System.out.println(lottoResult.convertYieldToString());
    }
}
