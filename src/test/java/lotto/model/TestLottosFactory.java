package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.generator.InputLottoNumberGenerator;
import lotto.generator.LottoNumberGenerator;

public class TestLottosFactory {
    private final LottoNumberGenerator lottoNumberGenerator;

    public TestLottosFactory(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public Lottos generate() {
        if (this.lottoNumberGenerator instanceof InputLottoNumberGenerator) {
            return createInputByRandomLottoNumberGenerator(lottoNumberGenerator);
        }
        throw new IllegalStateException("테스트용 로또 번호 생성기가 유효하지 않습니다.");
    }

    private static Lottos createInputByRandomLottoNumberGenerator(
            LottoNumberGenerator lottoNumberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.draw(lottoNumberGenerator));
        return Lottos.valueOf(lottos);
    }
}

