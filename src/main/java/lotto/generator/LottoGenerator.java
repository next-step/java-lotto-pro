package lotto.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class LottoGenerator {
    private final LottoNumberGenerator lottoNumberGenerator;

    private LottoGenerator(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public static LottoGenerator from(LottoNumberGenerator lottoNumberGenerator) {
        return new LottoGenerator(lottoNumberGenerator);
    }

    public Lottos generate(int autoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < autoCount; i++) {
            lottos.add(Lotto.from(lottoNumberGenerator.generate()));
        }

        return Lottos.from(lottos);
    }
}
