package lotto.lotto.ui.outputView;

import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.Lottos;

import java.util.List;

public class GeneratedLottosOutputView {

    public static void printLottos(List<Lottos> lottoses) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        for (Lottos lottos : lottoses) {
            for (Lotto lotto : lottos.getLottos()) {
                System.out.print(lotto.getNumber() + ",");
            }
            System.out.println();
        }

    }
}
