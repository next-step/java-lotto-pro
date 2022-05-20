package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSelfCountTest {

    @DisplayName("입력 받은 수동 로또 개수가 숫자가 아닌 경우 검증")
    @ParameterizedTest
    @ValueSource(strings = {"%%G", "10 00", "한번"})
    void lottoSelfCount_not_number(String selfMoneyWord) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoSelfCount(selfMoneyWord))
                .withMessage("[ERROR] 숫자가 아닙니다.");
    }

}
