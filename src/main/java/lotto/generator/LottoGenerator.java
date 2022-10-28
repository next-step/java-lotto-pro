package lotto.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;

public class LottoGenerator {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final Money priceOfOneLotto;

    private LottoGenerator(LottoNumberGenerator lottoNumberGenerator, Money priceOfOneLotto) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.priceOfOneLotto = priceOfOneLotto;
    }

    public static LottoGenerator of(LottoNumberGenerator lottoNumberGenerator, Money priceOfOneLotto) {
        return new LottoGenerator(lottoNumberGenerator, priceOfOneLotto);
    }

    public Lottos generate(Money purchaseAmount) {
        double count = purchaseAmount.divide(priceOfOneLotto);
        return generate((int) count);
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
