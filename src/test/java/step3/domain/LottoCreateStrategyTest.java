package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCreateStrategyTest {

    @DisplayName("로또 자동발급 전략패턴 인터페이스 적용")
    @Test
    void 로또_자동발급_전략패턴_적용() {
        LottoCreateStrategy strategy = new AutoLottoCreateStrategy();
        Lotto lotto = LottoMachine.getLotto(strategy);

        assertThat(lotto).isInstanceOf(Lotto.class);
        assertThat(lotto.lottoNumbers()).hasSize(6);
    }

    @DisplayName("로또 발급 후 일급컬렉션 getter 테스트")
    @Test
    void 로또_일급컬렉션_getter테스트() {
        Lotto lotto = LottoMachine.getLotto(new AutoLottoCreateStrategy());
        List<LottoNumber> lottoNumbers = lotto.lottoNumbers();
        lottoNumbers.remove(5);
        lottoNumbers.add(LottoCreateStrategy.lottoNumberMap.get(10));

        assertThat(lottoNumbers.equals(lotto.lottoNumbers())).isFalse();
    }
}
