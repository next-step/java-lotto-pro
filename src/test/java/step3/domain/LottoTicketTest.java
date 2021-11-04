package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class LottoTicketTest {

    @Test
    @DisplayName("입력 (1, 2, 3, 4, 5, 6) LottoTicket 생성, 숫자 포함 검증")
    void 로또_티켓_생성() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 6};

        // when
        LottoTicket lottoTicket = new LottoTicket(numbers);

        // then
        assertThat(lottoTicket.toLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_티켓_6개_숫자_미달() {
        // given
        int[] numbers = {1, 2, 3, 4, 5};

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                new LottoTicket(numbers);
            })
            // then
            .withMessageMatching(LottoConstant.LOTTO_TICKET_OVER_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    void 로또_티켓_6개_숫자_초과() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};

        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                new LottoTicket(numbers);
            })
            // then
            .withMessageMatching(LottoConstant.LOTTO_TICKET_OVER_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("LottoTicket 에게 변개 일치하는지 테스트, 검증 6(모두일치)")
    void containCounting() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 6};

        // when 
        LottoTicket lottoTicket = new LottoTicket(numbers);

        // then
        assertThat(lottoTicket.containCount(new LottoTicket(numbers))).isEqualTo(6);
    }

    @Test
    void toLottoNumbers() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 6};

        // when
        LottoTicket lottoTicket = new LottoTicket(numbers);

        // then
        assertThat(lottoTicket.toLottoNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    void toLottoNumbers_수정불가_테스트() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 6};

        // when
        LottoTicket lottoTicket = new LottoTicket(numbers);
        List<Integer> lottoNumbers = lottoTicket.toLottoNumbers();

        // then
        assertThatThrownBy(() -> {
            lottoNumbers.remove(0);
        })// then
            .isInstanceOf(UnsupportedOperationException.class);
    }
}
