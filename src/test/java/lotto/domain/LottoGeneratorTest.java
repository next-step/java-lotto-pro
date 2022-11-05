package lotto.domain;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoGenerator.PURCHASE_MINIMUM_COUNT_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호 생성기")
class LottoGeneratorTest {

    @DisplayName("생성")
    @Test
    void constructor() {
        assertThatNoException().isThrownBy(LottoGenerator::new);
    }

    @DisplayName("로또 번호 생성 시 구매 횟수는 음수일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void negative(int purchaseCount) {
        assertThatThrownBy(() -> new LottoGenerator().generate(purchaseCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_MINIMUM_COUNT_EXCEPTION_MESSAGE);
    }

    @DisplayName("구매횟수만큼 로또 번호들 리스트 생성")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void generate(int purchaseCount) {
        assertThat(new LottoGenerator().generate((purchaseCount))).hasSize(purchaseCount);
    }
}
