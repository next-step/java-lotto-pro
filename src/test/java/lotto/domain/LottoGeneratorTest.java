package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또 번호 생성기")
class LottoGeneratorTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(ints = {10000})
    void constructor(int lottoMoney) {
        new LottoMoney(lottoMoney);
        assertThatNoException().isThrownBy(() -> new LottoGenerator());
    }

    @DisplayName("구매횟수만큼 로또 번호들 리스트 생성")
    @ParameterizedTest
    @ValueSource(ints = {3000, 4000, 5000})
    void generate(int lottoMoney) {
        assertThat(LottoGenerator.generate(new LottoMoney(lottoMoney).purchaseCount()).getLottos()).hasSize(lottoMoney / 1000);
    }
}
