package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoTicketFactoryTest {
    @DisplayName("로또 번호 생성 테스트")
    @RepeatedTest(10)
    void lottoNumbersTest() {
        assertNotNull(LottoTicketFactory.createLottoTicket());
    }

    @DisplayName("문자열 번호 숫자로 변환 테스트")
    @Test
    void convertInputNumbersToNumbers() {
        LottoTicketFactory.createManualLottoTicket("1, 10, 15, 20, 25, 30");
    }

    @DisplayName("문자열 번호 숫자로 변환 테스트 - 문자나 음수")
    @Test
    void convertInputNumbersToNumbersException() {
        assertThatThrownBy(() -> LottoTicketFactory.createManualLottoTicket("a,b,c,d,e,f"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_POSITIVE_LOTTO_NUMBER_MESSAGE.getMessage());

        assertThatThrownBy(() -> LottoTicketFactory.createManualLottoTicket("-1,-2,-3,-4,-5,-6"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.NON_POSITIVE_LOTTO_NUMBER_MESSAGE.getMessage());
    }
}
