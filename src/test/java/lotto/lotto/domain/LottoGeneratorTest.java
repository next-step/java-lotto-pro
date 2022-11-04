package lotto.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 번호 생성기")
class LottoGeneratorTest {

    @DisplayName("생성")
    @Test
    void constructor() {
        assertThatNoException().isThrownBy(() -> new LottoGenerator(2));
    }
}
