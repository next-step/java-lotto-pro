package lotto.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;

public class LottoGenerator {
    private final LottoNumberGenerator lottoNumberGenerator;

    private LottoGenerator(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public static LottoGenerator from(LottoNumberGenerator lottoNumberGenerator) {
        return new LottoGenerator(lottoNumberGenerator);
    }

    public List<Lotto> generate(Money purchasePrice) {
        int count = purchasePrice.purchasableQuantity();
        return generate(count);
    }

    private List<Lotto> generate(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.from(lottoNumberGenerator.generate()));
        }

        return lottos;
    }
}
