package lotto.lotto.ui.outputView;

import common.vo.Number;
import lotto.lotto.domain.Lotto;

import java.util.List;

public class GeneratedLottosOutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        for (Lotto lotto : lottos) {
            printLotto(lotto);
            System.out.println();
        }

    }

    private static void printLotto(Lotto lotto) {
        for (Number number : lotto.getLottos()) {
            System.out.print(number.getNumber() + ",");
        }
    }
}
