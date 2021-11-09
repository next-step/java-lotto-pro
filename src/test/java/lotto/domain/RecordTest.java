package lotto.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTest {
    @DisplayName("보너스 번호가 없는 경우")
    @Nested
    class NoBonusNumber {
        private Record record;

        @BeforeEach
        void setUp() {
            List<LottoNumbers> lottoNumbersList = Arrays.asList(
                    LottoNumbers.of("1,2,3,7,8,9"),
                    LottoNumbers.of("1,2,3,4,7,8"),
                    LottoNumbers.of("9,8,3,4,5,6"),
                    LottoNumbers.of("1,2,3,4,5,45"),
                    LottoNumbers.of("1,2,3,4,5,6")
            );
            WinningLottoNumbers winningNumber = new WinningLottoNumbers(LottoNumbers.of("1,2,3,4,5,6"));
            record = new Record(new LotteryTicket(lottoNumbersList), winningNumber);
        }

        @DisplayName("각 등수와 일치하는 갯수를 반환한다")
        @ParameterizedTest
        @CsvSource(value = {"FOURTH:1", "THIRD:2", "SECOND:1", "FIRST:1"}, delimiter = ':')
        void testCount(Rank rank, long count) {
            assertThat(record.getWinningCount(rank)).isEqualTo(count);
        }

        @DisplayName("각 등수별 당첨 금액 총합을 반환한다")
        @ParameterizedTest
        @CsvSource(value = {"FOURTH:5000", "THIRD:100000", "SECOND:1500000", "FIRST:2000000000"}, delimiter = ':')
        void testWinningMoney(Rank rank, long money) {
            assertThat(record.getWinningMoney(rank)).isEqualTo(Money.of(money));
        }

        @DisplayName("총 당첨 금액을 반환한다")
        @Test
        void testTotalWinningMoney() {
            assertThat(record.getTotalWinningMoney()).isEqualTo(Money.of(2000000000 + 1500000 + 100000 + 5000));
        }

        @DisplayName("수익률을 반환한다 (당첨금액 / 구입금액)")
        @Test
        void testProfitRate() {
            double expectedRate = (2000000000 + 1500000 + 100000 + 5000) / 25000d;
            assertThat(record.getProfitRate()).isEqualTo(expectedRate, Offset.offset(0.005));
        }
    }

    @DisplayName("보너스 번호가 있는 경우")
    @Nested
    class HasBonusNumber {
        private Record record;

        @BeforeEach
        void setUp() {
            List<LottoNumbers> lottoNumbersList = Arrays.asList(
                    LottoNumbers.of("1,2,3,7,8,9"),
                    LottoNumbers.of("1,2,3,4,7,8"),
                    LottoNumbers.of("9,8,3,4,5,6"),
                    LottoNumbers.of("9,2,3,4,5,6"),
                    LottoNumbers.of("1,2,3,4,5,45"),
                    LottoNumbers.of("1,2,3,4,5,6")
            );
            WinningLottoNumbers winningNumber = new WinningLottoNumbers(LottoNumbers.of("1,2,3,4,5,6"), LottoNumber.of(45));
            record = new Record(new LotteryTicket(lottoNumbersList), winningNumber);
        }

        @DisplayName("각 등수와 일치하는 갯수를 반환한다")
        @ParameterizedTest
        @CsvSource(value = {"FOURTH:1", "THIRD:2", "SECOND:1", "SECOND_WITH_BONUS:1", "FIRST:1"}, delimiter = ':')
        void testCount(Rank rank, long count) {
            assertThat(record.getWinningCount(rank)).isEqualTo(count);
        }

        @DisplayName("각 등수별 당첨 금액 총합을 반환한다")
        @ParameterizedTest
        @CsvSource(value = {"FOURTH:5000", "THIRD:100000", "SECOND:1500000", "SECOND_WITH_BONUS:30000000", "FIRST:2000000000"}, delimiter = ':')
        void testWinningMoney(Rank rank, long money) {
            assertThat(record.getWinningMoney(rank)).isEqualTo(Money.of(money));
        }

        @DisplayName("총 당첨 금액을 반환한다")
        @Test
        void testTotalWinningMoney() {
            assertThat(record.getTotalWinningMoney()).isEqualTo(Money.of(2000000000 + 30000000 + 1500000 + 100000 + 5000));
        }

        @DisplayName("수익률을 반환한다 (당첨금액 / 구입금액)")
        @Test
        void testProfitRate() {
            double expectedRate = (2000000000 + 30000000 + 1500000 + 100000 + 5000) / 30000d;
            assertThat(record.getProfitRate()).isEqualTo(expectedRate, Offset.offset(0.005));
        }
    }
}
