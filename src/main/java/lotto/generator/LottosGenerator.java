package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottosGenerator {
    public static Lottos purchaseManualAndAutoLottos(Money money, List<Lotto> fixedLottos){
        Lottos manualLottos = purchaseManualLottos(fixedLottos);
        Lottos autoLottos = purchaseAutoLottos(money.subtract(fixedLottos.size() * Money.LOTTO_PRICE));
        return mergeLottos(manualLottos, autoLottos);
    }

    public static Lottos purchaseManualLottos(List<Lotto> manualLottos){
        return new Lottos(manualLottos);
    }

    public static Lottos purchaseAutoLottos(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < money.maxLottoCount(); i++) {
            lottoList.add(new Lotto(RandomLottoNumbersGenerator.generate()));
        }
        return new Lottos(lottoList);
    }

    private static Lottos mergeLottos(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> merged = new ArrayList<>();
        merged.addAll(manualLottos.getLottosAsUnmodifiableList());
        merged.addAll(autoLottos.getLottosAsUnmodifiableList());
        return new Lottos(merged);
    }
}
