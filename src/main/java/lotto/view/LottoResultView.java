package lotto.view;

import static lotto.constants.LottoGuideMessage.PURCHASE_COUNT;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoResultView {

    public void printLottos(Lottos lottos) {

        System.out.printf((PURCHASE_COUNT) + "%n", lottos.getCount());

        for (Lotto lotto : lottos.getReadOnlyLottos()){
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
