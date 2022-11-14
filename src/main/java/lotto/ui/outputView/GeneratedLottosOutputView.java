package lotto.ui.outputView;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosMap;

import java.util.List;

import static lotto.domain.LottoType.AUTO;
import static lotto.domain.LottoType.MANUAL;

public class GeneratedLottosOutputView {

    public static final String MANUAL_COUNT_MESSAGE = "수동으로 %d 장 ";
    public static final String AUTO_COUNT_MESSAGE = "자동으로 %d 개를 구매했습니다.";

    public static void printLottos(LottosMap lottosMap) {
        System.out.printf(MANUAL_COUNT_MESSAGE, lottosMap.getLottos(MANUAL).size());
        System.out.printf(AUTO_COUNT_MESSAGE, lottosMap.getLottos(AUTO).size());
        System.out.println();
        print(lottosMap.getLottos(MANUAL));
        print(lottosMap.getLottos(AUTO));
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
