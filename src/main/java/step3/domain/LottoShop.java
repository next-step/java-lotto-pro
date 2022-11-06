package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {

    private final RandomGenerateStrategy randomGenerateStrategy;

    public LottoShop(RandomGenerateStrategy randomGenerateStrategy) {
        this.randomGenerateStrategy = randomGenerateStrategy;
    }

    public Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.createLotto(randomGenerateStrategy));
        }
        return new Lottos(lottos);
    }

    public static Lottos buy(List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
            .map(LottoGenerator::create)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }
}
