package lotto.domain;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ManualCountTest {
    @DisplayName("수동 구매 개수 0개인 객체 생성")
    @Test
    void test_0개_생성() {
        //given & when & then
        assertThat(ManualCount.create()).isEqualTo(ManualCount.from(0));
    }

    @DisplayName("수동 번호 입력 시 지정한 수동 개수를 초과한 경우 예외 처리")
    @Test
    void test_지정한_수동_개수_초과() {
        //given
        ManualCount manualCount = ManualCount.from(3);
        int alreadyPurchaseLottoTicketSize = 4;
        //when & then
        assertThatThrownBy(() -> manualCount.isRemainingCount(alreadyPurchaseLottoTicketSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.GREATER_THEN_MANUAL_COUNT, manualCount));
    }
}