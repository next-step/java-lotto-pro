package lotto.model.lotto.ticket;

import lotto.model.winning.numbers.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTicketTest {
    @Nested
    @DisplayName("LottoTicket 생성자 테스트")
    class Constructor {
        @RepeatedTest(value = 100)
        @DisplayName("성공")
        void success() {
            final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            assertDoesNotThrow(() -> new LottoTicket(lottoNumberGenerator));
        }
    }

    static class LottoNumberGeneratorForTest extends LottoNumberGenerator {
        @Override
        public List<LottoNumber> generate() {
            return new ArrayList<>(Arrays.asList(
                    new LottoNumber(1),
                    new LottoNumber(45),
                    new LottoNumber(9),
                    new LottoNumber(27),
                    new LottoNumber(10),
                    new LottoNumber(2)
            ));
        }
    }

    @Nested
    @DisplayName("numberMatch 메서드 테스트")
    class NumberMatch {
        private final LottoTicket lottoTicket = new LottoTicket(new LottoNumberGeneratorForTest());

        @Test
        @DisplayName("결과가 0 개일 때 성공")
        void zero() {
            final WinningNumbers winningNumbers = new WinningNumbers("3, 4, 5, 6, 7, 8");
            final int result = lottoTicket.numberMatch(winningNumbers);
            assertThat(result).isEqualTo(0);
        }

        @Test
        @DisplayName("결과가 1 개일 때 성공")
        void one() {
            final WinningNumbers winningNumbers = new WinningNumbers("1, 4, 5, 6, 7, 8");
            final int result = lottoTicket.numberMatch(winningNumbers);
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("결과가 2 개일 때 성공")
        void two() {
            final WinningNumbers winningNumbers = new WinningNumbers("1, 45, 5, 6, 7, 8");
            final int result = lottoTicket.numberMatch(winningNumbers);
            assertThat(result).isEqualTo(2);
        }

        @Test
        @DisplayName("결과가 3 개일 때 성공")
        void three() {
            final WinningNumbers winningNumbers = new WinningNumbers("1, 45, 9, 6, 7, 8");
            final int result = lottoTicket.numberMatch(winningNumbers);
            assertThat(result).isEqualTo(3);
        }

        @Test
        @DisplayName("결과가 4 개일 때 성공")
        void four() {
            final WinningNumbers winningNumbers = new WinningNumbers("1, 45, 9, 27, 7, 8");
            final int result = lottoTicket.numberMatch(winningNumbers);
            assertThat(result).isEqualTo(4);
        }

        @Test
        @DisplayName("결과가 5 개일 때 성공")
        void five() {
            final WinningNumbers winningNumbers = new WinningNumbers("1, 45, 9, 27, 10, 8");
            final int result = lottoTicket.numberMatch(winningNumbers);
            assertThat(result).isEqualTo(5);
        }

        @Test
        @DisplayName("결과가 6 개일 때 성공")
        void six() {
            final WinningNumbers winningNumbers = new WinningNumbers("1, 45, 9, 27, 10, 2");
            final int result = lottoTicket.numberMatch(winningNumbers);
            assertThat(result).isEqualTo(6);
        }
    }
}
