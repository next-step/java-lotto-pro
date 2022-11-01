package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import step3.io.InputView;
import step3.utils.NumbersGenerator;

public class LottoStore {

    public static final Money pricePerLotto = Money.generate(1000);

    public Lottos sell(Money payment) {
        return sell(payment, generateManualLottos(0));
    }

    public Lottos sell(Money payment, List<Lotto> manualLottos) {
        int totalCount = payment.divide(pricePerLotto);
        int manualCount = manualLottos.size();
        validate(totalCount, manualCount);
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        lottos.addAll(generateAutoLottos(totalCount - manualCount));
        return Lottos.generate(lottos);
    }

    public List<Lotto> generateManualLottos(int manualCount) {
        if (manualCount == 0) {
            return Collections.emptyList();
        }
        InputView.printInputManualNumbers();
        return generateLottos(manualCount, NumbersGenerator::userInput);
    }

    private List<Lotto> generateAutoLottos(int autoCount) {
        return new ArrayList<>(generateLottos(autoCount, NumbersGenerator::random));
    }

    private List<Lotto> generateLottos(int lottoCount, Supplier<UniqueNumbers> numbersSupplier) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            UniqueNumbers random = numbersSupplier.get();
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
