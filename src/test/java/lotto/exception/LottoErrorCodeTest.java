package lotto.exception;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoErrorCodeTest {

    @DisplayName("에러코드 메시지 생성")
    @Test
    void makePrintableMessage() {
        assertThat(LottoErrorCode.INVALID_MONEY.makePrintableMessage()).isEqualTo("0 이상의 숫자를 입력해주세요.");
    }
}