package lotto.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.lotto.domain.LottoGenerator.NEGATIVE_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호 생성기")
class LottoGeneratorTest {

    @DisplayName("생성")
    @Test
    void constructor() {
        assertThatNoException().isThrownBy(() -> new LottoGenerator(2));
    }

    @DisplayName("음수일 수 없다.")
    @Test
    void negative() {
        assertThatThrownBy(() -> new LottoGenerator(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_EXCEPTION_MESSAGE);
    }

    @DisplayName("구매횟수만큼 로또 번호들 리스트 생성")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void generate(int purchaseCount) {
        assertThat(new LottoGenerator(purchaseCount).generateLottos()).hasSize(purchaseCount);
    }
}
