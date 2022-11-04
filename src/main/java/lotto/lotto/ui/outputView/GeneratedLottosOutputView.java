package lotto.lotto.ui.outputView;

import lotto.lotto.domain.Number;
import lotto.lotto.domain.Lotto;

import java.util.List;

public class GeneratedLottosOutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        for (Lotto lotto : lottos) {
            for (Number number : lotto.getLottos()) {
                System.out.print(number.getNumber() + ",");
            }
            System.out.println();
        }

    }
}
