package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.common.exception.InvalidParamException;
import step3.domain.WinningLotto;
import step3.domain.constance.LottoConstant;

public class WinningLottoTest {

    @Test
    @DisplayName("우승 번호에 보너스 번호 포함시 예외 발생")
    void valid() {
        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
            }) // then
            .withMessageMatching(LottoConstant.BONUS_NUMBER_ALREADY_EXIST_MESSAGE);
    }
}
