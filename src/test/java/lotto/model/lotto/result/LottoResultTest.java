package lotto.model.lotto.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoResultTest {
    @Nested
    @DisplayName("LottoResult 생성자 테스트")
    class Constructor {
        @Test
        @DisplayName("LottoResult 객체 생성 성공")
        void success() {
            final int[][] prizes = new int[][] { {3, 5000}, {4, 50000}, {5, 150000}, {6, 2000000000} };
            final Map<Integer, Integer> prizeMoney = new HashMap<>();
            final Map<Integer, Integer> lottoCount = new HashMap<>();
            for (int[] prize : prizes) {
                prizeMoney.put(prize[0], prize[1]);
                lottoCount.put(prize[0], 0);
            }
            assertDoesNotThrow(() -> new LottoResult(prizeMoney, lottoCount));
        }
    }

    @Nested
    @DisplayName("prizeMoneyForNumbersMatch 메서드 테스트")
    class PrizeMoneyForNumbersMatch {
        private final LottoResult lottoResult;

        PrizeMoneyForNumbersMatch() {
            final int[][] prizes = new int[][] { {3, 5000}, {4, 50000}, {5, 150000}, {6, 2000000000} };
            final Map<Integer, Integer> prizeMoney = new HashMap<>();
            final Map<Integer, Integer> lottoCount = new HashMap<>();
            for (int[] prize : prizes) {
                prizeMoney.put(prize[0], prize[1]);
                lottoCount.put(prize[0], 0);
            }
            lottoResult = new LottoResult(prizeMoney, lottoCount);
        }

        @ParameterizedTest
        @CsvSource(value = {"3, 5000", "4, 50000", "5, 150000", "6, 2000000000"}, delimiter = ',')
        @DisplayName("일치하는 숫자 개수에 맞는 당첨 상금을 반환한다")
        void success(int numbersMatch, int prize) {
            assertThat(lottoResult.prizeMoneyForNumbersMatch(numbersMatch)).isEqualTo(prize);
        }
    }

    @Nested
    @DisplayName("lottoCountForNumbersMatch 메서드 테스트")
    class LottoCountForNumbersMatch {
        private final LottoResult lottoResult;

        LottoCountForNumbersMatch() {
            final int[][] prizes = new int[][] { {3, 5000}, {4, 50000}, {5, 150000}, {6, 2000000000} };
            final Map<Integer, Integer> prizeMoney = new HashMap<>();
            for (int[] prize : prizes) {
                prizeMoney.put(prize[0], prize[1]);
            }
            final int[][] counts = new int[][] { {3, 4}, {4, 2}, {5, 1}, {6, 0} };
            final Map<Integer, Integer> lottoCount = new HashMap<>();
            for (int[] count : counts) {
                lottoCount.put(count[0], count[1]);
            }
            lottoResult = new LottoResult(prizeMoney, lottoCount);
        }

        @ParameterizedTest
        @CsvSource(value = {"3, 4", "4, 2", "5, 1", "6, 0"}, delimiter = ',')
        @DisplayName("일치하는 숫자 개수에 맞는 당첨 상금을 반환한다")
        void success(int numbersMatch, int count) {
            assertThat(lottoResult.lottoCountForNumbersMatch(numbersMatch)).isEqualTo(count);
        }
    }
}
