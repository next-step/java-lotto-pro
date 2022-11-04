package lotto.lotto.ui.outputView;

import lotto.lotto.domain.Lotto;

import java.util.List;

public class GeneratedLottosOutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
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
