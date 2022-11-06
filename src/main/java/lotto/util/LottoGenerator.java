package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static Lottos createUserWrittenLottos(List<List<Integer>> userWrittenLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> userWrittenLotto : userWrittenLottos) {
            lottos.add(Lotto.from(userWrittenLotto));
        }
        return Lottos.from(lottos);
    }

    public static Lottos createAutoLottos(int autoLottoAmount) {
        List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < autoLottoAmount; i++) {
            Lotto lotto = Lotto.from(LottoNumberGenerator.generateLottoNumbers());
            autoLottos.add(lotto);
        }
        return Lottos.from(autoLottos);
    }

}
