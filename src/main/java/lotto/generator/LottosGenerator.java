package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottosGenerator {
    public static Lottos purchaseManualAndAutoLottos(Money money, List<Lotto> fixedLottos){
        Lottos manualLottos = purchaseManualLottos(fixedLottos);
        Lottos autoLottos = purchaseAutoLottos(money.subtract(manualLottos.price()));
        return mergeLottos(manualLottos, autoLottos);
    }

    public static Lottos purchaseManualLottos(List<Lotto> manualLottos){
        return Lottos.from(manualLottos);
    }

    public static Lottos purchaseAutoLottos(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        LottoCount purchaseCount = money.maxLottoCount();
        for (int i = 0; i < purchaseCount.getCount(); i++) {
            lottoList.add(Lotto.from(RandomLottoNumbersGenerator.generate()));
        }
        return Lottos.from(lottoList);
    }

    private static Lottos mergeLottos(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> merged = new ArrayList<>();
        merged.addAll(manualLottos.getLottosAsUnmodifiableList());
        merged.addAll(autoLottos.getLottosAsUnmodifiableList());
        return Lottos.from(merged);
    }
}
