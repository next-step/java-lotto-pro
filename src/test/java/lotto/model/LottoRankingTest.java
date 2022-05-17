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
    @DisplayName("로또 일치 카운트, 보너스일치 여부로 구한 로또 랭킹 반환 테스트")
    @Test
    void lottoRanking() {
        assertAll(
                () -> assertThat(LottoRanking.findLottoRankingByCountOfMatchAndBonusMatched(6, false)).isEqualTo(
                        LottoRanking.FIRST),
                () -> assertThat(LottoRanking.findLottoRankingByCountOfMatchAndBonusMatched(5, false)).isEqualTo(
                        LottoRanking.THIRD),
                () -> assertThat(LottoRanking.findLottoRankingByCountOfMatchAndBonusMatched(5, true)).isEqualTo(
                        LottoRanking.SECOND),
                () -> assertThat(LottoRanking.findLottoRankingByCountOfMatchAndBonusMatched(2, false)).isEqualTo(
                        LottoRanking.MISS)
        );
    }

    @DisplayName("로또 일치 카운트, 보너스일치 여부로 구한 로또 랭킹 상금(돈) 테스트")
    @ParameterizedTest(name = "로또 일치 카운트 {0}, 보너스일치 여부 {1}로 구한 로또 랭킹 상금(돈) {2} 테스트")
    @CsvSource(value = {"2:false:0", "5:false:1500000", "5:true:30000000", "6:false:2000000000"}, delimiter = ':')
    void lottoRankingMoney(int countOfMatch, boolean isBonusMatched, int expect) {
        assertThat(
                LottoRanking.findLottoRankingByCountOfMatchAndBonusMatched(countOfMatch, isBonusMatched).money()).isEqualTo(
                Money.valueOf(expect));
    }

    @DisplayName("로또번호 일치 갯수가 유효하지 유효하지 않을 때 IllegalArgumentException 예외")
    @ParameterizedTest(name = "로또번호 일치 갯수 {0}가 유효하지 유효하지 않을 때 IllegalArgumentException 예외")
    @ValueSource(strings = {"7", "-1", "10"})
    void lottoRankingInvalidateCountOfMatch(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRanking.findLottoRankingByCountOfMatchAndBonusMatched(input, false))
                .withMessage("로또번호 일치 갯수가 유효하지 않습니다.");
    }
}
