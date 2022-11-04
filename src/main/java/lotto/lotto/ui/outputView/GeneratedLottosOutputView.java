package lotto.lotto.ui.outputView;

import lotto.lotto.domain.Lotto;

import java.util.List;

public class GeneratedLottosOutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.getLottos().get(i).getNumber());
            printDelimiter(lotto, i);
        }
        System.out.print("]");
        System.out.println();
    }

    private static void printDelimiter(Lotto lotto, int i) {
        if (i + 1 != lotto.size()) {
            System.out.print(",");
        }
    }
}
