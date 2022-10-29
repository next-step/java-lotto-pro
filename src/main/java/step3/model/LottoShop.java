package step3.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoShop {
    public LottoPaper buyLotto(Money money, List<LottoGenerator> lottoGenerators) {

        for (int i = 0; i < money.countOfLottoPurchases() - lottoGenerators.size(); i++) {
            lottoGenerators.add(new LottoAutoGenerator());
        }

        return new LottoPaper(
            lottoGenerators.stream()
                .map(LottoGenerator::generateLotto)
                .collect(Collectors.toList())
        );
    }
}
