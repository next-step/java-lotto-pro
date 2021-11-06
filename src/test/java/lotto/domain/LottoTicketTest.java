package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

class LottoTicketTest {

    @DisplayName("로또티켓 생성")
    @Test
    void constructLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("입력받은 로또티켓 생성")
    @Test
    void constructLottoTicketFromText_success() {
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("잘못된 입력으로 로또티켓 생성시 에러")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "asd,2,3,4,5,6", "-1,2,3,4,5,6", "1,2,3,4,5,5", ""})
    void throwsError_whenInvalidTextLottoTicket(String invalidText) {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new LottoTicket(invalidText))
            .withMessage("1 ~ 45의 숫자 중 중복되지 않은 숫자 6개를 입력해주세요.");
    }

    @DisplayName("로또티켓 결과 계산")
    @ParameterizedTest
    @CsvSource(value = {"4, 5, 6, 7, 8, 9;THREE", "4, 5, 6, 1, 8, 9;FOUR", "4, 5, 6, 1, 2, 9;FIVE",
        "4, 5, 6, 1, 2, 3;SIX", "7, 8, 9, 10, 11, 12;NONE"}, delimiter = ';')
    public void calculateResult(String text, String resultName) {
        LottoTicket lottoTicket = new LottoTicket(text);
        assertThat(lottoTicket.calculateResult(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6))))
            .isEqualTo(LottoResult.valueOf(resultName));
    }

    @DisplayName("로또티켓 메시지 생성")
    @Test
    void makeMessage() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.makePrintableMessage()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}