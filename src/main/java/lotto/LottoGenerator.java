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

    public static LottoGenerator from(LottoNumberGenerator lottoNumberGenerator, Money price) {
        return new LottoGenerator(lottoNumberGenerator, price);
    }

    public Lottos generate(Money money) {
        int count = money.divide(price);
        return generate(count);
    }

    private Lottos generate(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            LottoNumbers lottoNumbers = LottoNumbers.from(lottoNumberGenerator.generate());
            lottos.add(Lotto.from(lottoNumbers, new DefaultWinPolicy()));
        }

        return Lottos.from(lottos);
    }
}
