package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoGenerator.NULL_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호 생성기")
class LottoGeneratorTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(ints = {10000})
    void constructor(int lottoMoney) {
        assertThatNoException().isThrownBy(() -> new LottoGenerator(new LottoMoney(lottoMoney)));
    }

    @DisplayName("구매 금액은 null일 수 없다.")
    @ParameterizedTest
    @NullSource
    void maxSize(LottoMoney lottoMoney) {
        assertThatThrownBy(() -> new LottoGenerator(lottoMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NULL_EXCEPTION_MESSAGE);
    }

    @DisplayName("구매횟수만큼 로또 번호들 리스트 생성")
    @ParameterizedTest
    @ValueSource(ints = {3000, 4000, 5000})
    void generate(int lottoMoney) {
        assertThat(new LottoGenerator(new LottoMoney(lottoMoney)).generate().getLottos()).hasSize(lottoMoney / 1000);
    }
}
