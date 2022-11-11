package lotto.ui.outputView;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Map;

public class GeneratedLottosOutputView {

    public static void printLottos(Map<String, Lottos> lottos) {
        System.out.print("수동으로 " + lottos.get("manual").size() + "장 ");
        System.out.println("자동으로 " + lottos.get("auto").size() + "개를 구매했습니다.");
        print(lottos.get("manual"));
        print(lottos.get("auto"));
        System.out.println();
    }

    private static void print(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto.sort());
        }
    }

    private static void printLotto(List<Integer> lottoNumbers) {
        System.out.print("[");
        for (int i = 0; i < lottoNumbers.size(); i++) {
            System.out.print(lottoNumbers.get(i));
            printDelimiter(lottoNumbers.size(), i);
        }
        System.out.print("]");
        System.out.println();
    }

    private static void printDelimiter(int lottoSize, int i) {
        if (i + 1 != lottoSize) {
            System.out.print(",");
        }
    }
}
