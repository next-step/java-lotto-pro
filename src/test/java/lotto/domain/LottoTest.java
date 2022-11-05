package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.domain.Lotto.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또")
class LottoTest {

    @DisplayName("로또 생성")
    @ParameterizedTest
    @MethodSource("lotto.fixture.LottoFixture#constructor")
    void constructor(List<Integer> lottoNumbers) {
        assertThatNoException().isThrownBy(() -> new Lotto(lottoNumbers));
    }

    @DisplayName("6개 이상의 수를 추가 할 수 없다.")
    @ParameterizedTest
    @MethodSource("lotto.fixture.LottoFixture#lottoSize")
    void maxSize(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SIZE + "개여야합니다.");
    }

    @DisplayName("중복된 수를 추가할 수 없다.")
    @ParameterizedTest
    @MethodSource("lotto.fixture.LottoFixture#duplicate")
    void duplicate(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }
}
