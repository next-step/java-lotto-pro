package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoOutPutView {
    public static void writeBuyLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.lottoNumbers());
        }
    }
}
