package lotto.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;

public class LottoGenerator {
    private final LottoNumberGenerator lottoNumberGenerator;

    private LottoGenerator(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public static LottoGenerator of(LottoNumberGenerator lottoNumberGenerator) {
        return new LottoGenerator(lottoNumberGenerator);
    }

    public Lottos generate(Money purchaseAmount) {
        int count = purchaseAmount.purchasableQuantity();
        return generate(count);
    }

    private Lottos generate(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            LottoNumbers lottoNumbers = LottoNumbers.from(lottoNumberGenerator.generate());
            lottos.add(Lotto.from(lottoNumbers));
        }

        return Lottos.from(lottos);
    }
}
