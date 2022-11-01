package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import step3.utils.NumbersGenerator;

public class LottoStore {

    public static final Money pricePerLotto = Money.generate(1000);

    public Lottos sell(Money payment) {
        return sell(payment, Collections.emptyList());
    }

    public Lottos sell(Money payment, List<UniqueNumbers> manualNumbersList) {
        int totalCount = payment.divide(pricePerLotto);
        int manualCount = manualNumbersList.size();
        validate(totalCount, manualCount);
        List<Lotto> lottos = generateManualLottos(manualNumbersList);
        lottos.addAll(generateAutoLottos(totalCount - manualCount));
        return Lottos.generate(lottos);
    }

    private List<Lotto> generateManualLottos(List<UniqueNumbers> manualNumbersList) {
        return manualNumbersList.stream()
                .map(Lotto::generate)
                .collect(Collectors.toList());
    }

    private List<Lotto> generateAutoLottos(int autoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < autoCount; count++) {
            UniqueNumbers random = NumbersGenerator.random();
            lottos.add(Lotto.generate(random));
        }
        return lottos;
    }

    private void validate(int divide, int manualCount) {
        if (divide == 0 || divide < manualCount) {
            throw new IllegalArgumentException("You don't have enough money.");
        }
    }
}
