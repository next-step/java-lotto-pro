package lotto.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

    @ParameterizedTest
    @DisplayName("6개 맞췄을때의 수익을 계산한다")
    @CsvSource(value = {"1:2000000000", "2:2000000000", "3:2000000000"}, delimiter = ':')
    void profit_six(int matchCount, int expected) {
        LottoResult matchThree = LottoResult.SIX;
        for (int i = 0; i < matchCount; i++) {
            matchThree.calculateTotalCount(6);
        }
        assertThat(matchThree.profit()).isEqualTo(matchCount * expected);
    }

    @ParameterizedTest
    @DisplayName("5개 맞췄을때의 수익을 계산한다")
    @CsvSource(value = {"1:1500000", "2:1500000", "3:1500000"}, delimiter = ':')
    void profit_five(int matchCount, int expected) {
        LottoResult matchThree = LottoResult.FIVE;
        for (int i = 0; i < matchCount; i++) {
            matchThree.calculateTotalCount(5);
        }
        assertThat(matchThree.profit()).isEqualTo(matchCount * expected);
    }

    @ParameterizedTest
    @DisplayName("4개 맞췄을때의 수익을 계산한다")
    @CsvSource(value = {"1:50000", "2:50000", "3:50000"}, delimiter = ':')
    void profit_four(int matchCount, int expected) {
        LottoResult matchThree = LottoResult.FOUR;
        for (int i = 0; i < matchCount; i++) {
            matchThree.calculateTotalCount(4);
        }
        assertThat(matchThree.profit()).isEqualTo(matchCount * expected);
    }

    @ParameterizedTest
    @DisplayName("3개 맞췄을때의 수익을 계산한다")
    @CsvSource(value = {"1:5000", "2:5000", "3:5000"}, delimiter = ':')
    void profit_three(int matchCount, int expected) {
        LottoResult matchThree = LottoResult.THREE;
        for (int i = 0; i < matchCount; i++) {
            matchThree.calculateTotalCount(3);
        }
        assertThat(matchThree.profit()).isEqualTo(matchCount * expected);
    }
}
