package lotto.domain;

import lotto.fixture.LottoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.domain.Lotto.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또")
class LottoTest {

    @DisplayName("로또 생성")
    @Test
    void constructor() {
        assertThatNoException().isThrownBy(LottoFixture::constructor);
    }

    @DisplayName("6개 이상의 수를 추가 할 수 없다.")
    @Test
    void maxSize() {
        assertThatThrownBy(LottoFixture::overSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SIZE + "개여야합니다.");
    }

    @DisplayName("중복된 수를 추가할 수 없다.")
    @Test
    void duplicate() {
        assertThatThrownBy(LottoFixture::duplicate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }
}
