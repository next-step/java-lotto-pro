package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.money.Money;
import lotto.win.DefaultWinPolicy;

public class LottoGenerator {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final Money price;

    private LottoGenerator(LottoNumberGenerator lottoNumberGenerator, Money price) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.price = price;
    }

    public static LottoGenerator of(LottoNumberGenerator lottoNumberGenerator, Money price) {
        return new LottoGenerator(lottoNumberGenerator, price);
    }

    public Lottos generate(Money money) {
        double count = money.divide(price);
        return generate((int) count);
    }

    private Lottos generate(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            LottoNumbers lottoNumbers = LottoNumbers.from(lottoNumberGenerator.generate());
            lottos.add(Lotto.of(lottoNumbers, new DefaultWinPolicy()));
        }

        return Lottos.from(lottos);
    }
}
