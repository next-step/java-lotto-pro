package lotto.model.lotto.result;

import lotto.model.lotto.enums.LottoNumberMatchCount;
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
    private LottoNumberMatchCount convertToEnum(int numbersMatch) {
        if (numbersMatch == 3) {
            return LottoNumberMatchCount.THREE;
        }
        if (numbersMatch == 4) {
            return LottoNumberMatchCount.FOUR;
        }
        if (numbersMatch == 5) {
            return LottoNumberMatchCount.FIVE;
        }
        return LottoNumberMatchCount.SIX;
    }

    @Nested
    @DisplayName("LottoResult 생성자 테스트")
    class Constructor {
        @Test
        @DisplayName("LottoResult 객체 생성 성공")
        void success() {
            final Map<LottoNumberMatchCount, Integer> prizeMoney = new HashMap<>();
            prizeMoney.put(LottoNumberMatchCount.THREE, 5000);
            prizeMoney.put(LottoNumberMatchCount.FOUR, 50000);
            prizeMoney.put(LottoNumberMatchCount.FIVE, 150000);
            prizeMoney.put(LottoNumberMatchCount.SIX, 2000000000);
            final Map<LottoNumberMatchCount, Integer> lottoCount = new HashMap<>();
            assertDoesNotThrow(() -> new LottoResult(prizeMoney, lottoCount));
        }
    }

    @Nested
    @DisplayName("prizeMoneyForNumbersMatch 메서드 테스트")
    class PrizeMoneyForNumbersMatch {
        private final LottoResult lottoResult;

        PrizeMoneyForNumbersMatch() {
            final Map<LottoNumberMatchCount, Integer> prizeMoney = new HashMap<>();
            prizeMoney.put(LottoNumberMatchCount.THREE, 5000);
            prizeMoney.put(LottoNumberMatchCount.FOUR, 50000);
            prizeMoney.put(LottoNumberMatchCount.FIVE, 150000);
            prizeMoney.put(LottoNumberMatchCount.SIX, 2000000000);
            final Map<LottoNumberMatchCount, Integer> lottoCount = new HashMap<>();
            lottoResult = new LottoResult(prizeMoney, lottoCount);
        }

        @ParameterizedTest
        @CsvSource(value = {"3, 5000", "4, 50000", "5, 150000", "6, 2000000000"}, delimiter = ',')
        @DisplayName("일치하는 숫자 개수에 맞는 당첨 상금을 반환한다")
        void success(int numbersMatch, int prize) {
            final LottoNumberMatchCount lottoNumberMatchCount = convertToEnum(numbersMatch);
            assertThat(lottoResult.prizeMoneyForNumbersMatch(lottoNumberMatchCount)).isEqualTo(prize);
        }
    }

    @Nested
    @DisplayName("lottoCountForNumbersMatch 메서드 테스트")
    class LottoCountForNumbersMatch {
        private final LottoResult lottoResult;

        LottoCountForNumbersMatch() {
            final Map<LottoNumberMatchCount, Integer> prizeMoney = new HashMap<>();
            prizeMoney.put(LottoNumberMatchCount.THREE, 5000);
            prizeMoney.put(LottoNumberMatchCount.FOUR, 50000);
            prizeMoney.put(LottoNumberMatchCount.FIVE, 150000);
            prizeMoney.put(LottoNumberMatchCount.SIX, 2000000000);
            final LottoNumberMatchCount[] matchCounts = new LottoNumberMatchCount[] {
                    LottoNumberMatchCount.THREE,
                    LottoNumberMatchCount.FOUR,
                    LottoNumberMatchCount.FIVE,
                    LottoNumberMatchCount.SIX
            };
            final int[] counts = new int[] { 4, 2, 1, 0};
            final Map<LottoNumberMatchCount, Integer> lottoCount = new HashMap<>();
            for (int i = 0; i < matchCounts.length; ++i) {
                lottoCount.put(matchCounts[i], counts[i]);
            }
            lottoResult = new LottoResult(prizeMoney, lottoCount);
        }

        @ParameterizedTest
        @CsvSource(value = {"3, 4", "4, 2", "5, 1", "6, 0"}, delimiter = ',')
        @DisplayName("일치하는 숫자 개수에 맞는 당첨 상금을 반환한다")
        void success(int numbersMatch, int count) {
            final LottoNumberMatchCount lottoNumberMatchCount = convertToEnum(numbersMatch);
            assertThat(lottoResult.lottoCountForNumbersMatch(lottoNumberMatchCount)).isEqualTo(count);
        }
    }

    @Nested
    @DisplayName("sumOfPrizes 메서드 테스트")
    class SumOfPrizes {
        private final Map<LottoNumberMatchCount, Integer> prizeMoney;
        private final Map<LottoNumberMatchCount, Integer> lottoCount;
        private final LottoResult lottoResult;

        SumOfPrizes() {
            final Map<LottoNumberMatchCount, Integer> prizeMoney = new HashMap<>();
            prizeMoney.put(LottoNumberMatchCount.THREE, 5000);
            prizeMoney.put(LottoNumberMatchCount.FOUR, 50000);
            prizeMoney.put(LottoNumberMatchCount.FIVE, 150000);
            prizeMoney.put(LottoNumberMatchCount.SIX, 2000000000);
            this.prizeMoney = prizeMoney;
            final LottoNumberMatchCount[] matchCounts = new LottoNumberMatchCount[] {
                    LottoNumberMatchCount.THREE,
                    LottoNumberMatchCount.FOUR,
                    LottoNumberMatchCount.FIVE,
                    LottoNumberMatchCount.SIX
            };
            final int[] counts = new int[] { 4, 2, 1, 0};
            final Map<LottoNumberMatchCount, Integer> lottoCount = new HashMap<>();
            for (int i = 0; i < matchCounts.length; ++i) {
                lottoCount.put(matchCounts[i], counts[i]);
            }
            this.lottoCount = lottoCount;
            lottoResult = new LottoResult(prizeMoney, lottoCount);
        }

        @Test
        @DisplayName("성공")
        void success() {
            final int sumOfPrizesResult = lottoResult.sumOfPrizes();
            final int expectedResult =
                    prizeMoney.get(LottoNumberMatchCount.THREE) * lottoCount.get(LottoNumberMatchCount.THREE) +
                            prizeMoney.get(LottoNumberMatchCount.FOUR) * lottoCount.get(LottoNumberMatchCount.FOUR) +
                            prizeMoney.get(LottoNumberMatchCount.FIVE) * lottoCount.get(LottoNumberMatchCount.FIVE) +
                            prizeMoney.get(LottoNumberMatchCount.SIX) * lottoCount.get(LottoNumberMatchCount.SIX);
            assertThat(sumOfPrizesResult).isEqualTo(expectedResult);
        }
    }
}
