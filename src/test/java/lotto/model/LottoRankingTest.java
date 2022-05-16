package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankingTest {
    @DisplayName("로또 일치 카운트로 구한 로또 랭킹 반환 테스트")
    @Test
    void lottoRanking() {
        assertAll(
                () -> assertThat(LottoRanking.findLottoRankingByCountOfMatch(6)).isEqualTo(LottoRanking.FIRST),
                () -> assertThat(LottoRanking.findLottoRankingByCountOfMatch(5)).isEqualTo(LottoRanking.THIRD),
                () -> assertThat(LottoRanking.findLottoRankingByCountOfMatch(2)).isEqualTo(LottoRanking.MISS)
        );
    }

    @DisplayName("로또 일치 카운트로 구한 로또 랭킹 상금(돈) 테스트")
    @ParameterizedTest(name = "로또 일치 카운트 {0}로 구한 로또 랭킹 상금(돈) {1} 테스트")
    @CsvSource(value = {"2:0", "5:1500000", "6:2000000000"}, delimiter = ':')
    void lottoRankingMoney(int input, int expect) {
        assertThat(LottoRanking.findLottoRankingByCountOfMatch(input).money()).isEqualTo(Money.valueOf(expect));
    }

    @DisplayName("로또번호 일치 갯수가 유효하지 유효하지 않을 때 IllegalArgumentException 예외")
    @ParameterizedTest(name = "로또번호 일치 갯수 {0}가 유효하지 유효하지 않을 때 IllegalArgumentException 예외")
    @ValueSource(strings = {"7", "-1", "10"})
    void lottoRankingInvalidateCountOfMatch(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRanking.findLottoRankingByCountOfMatch(input))
                .withMessage("로또번호 일치 갯수가 유효하지 않습니다.");
    }
}
