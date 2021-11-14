package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    @DisplayName("랜덤한 로또 번호 6개를 선택해서 로또 번호 일급 컬렉션을 생성할 수 있다.")
    void pickRandom() {
        assertDoesNotThrow(LottoNumbers::pickRandom);
    }
}
