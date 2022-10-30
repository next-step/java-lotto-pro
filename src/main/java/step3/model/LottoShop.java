package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {
    public LottoPaper buyLotto(Money money) {
        List<LottoGenerator> lottoGenerators = new ArrayList<>();
        for (int i = 0; i < money.countOfLottoPurchases(); i++) {
            lottoGenerators.add(new AutoLottoGenerator());
        }

        return new LottoPaper(
            lottoGenerators.stream()
                .map(LottoGenerator::generateLotto)
                .collect(Collectors.toList())
        );
    }
}
