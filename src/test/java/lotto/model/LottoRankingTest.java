package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankingTest {
    @DisplayName("로또 일치 카운트, 보너스일치 여부로 구한 로또 랭킹 반환 테스트")
    @Test
    void lottoRanking() {
        assertAll(
                () -> assertThat(
                        LottoRanking.FIRST.predicateWithCountOfMatchAndIsBonusMatched().test(6, false)).isTrue(),
                () -> assertThat(
                        LottoRanking.THIRD.predicateWithCountOfMatchAndIsBonusMatched().test(5, false)).isTrue(),
                () -> assertThat(
                        LottoRanking.SECOND.predicateWithCountOfMatchAndIsBonusMatched().test(5, true)).isTrue(),
                () -> assertThat(
                        LottoRanking.SECOND.predicateWithCountOfMatchAndIsBonusMatched().test(5, false)).isFalse(),
                () -> assertThat(
                        LottoRanking.THIRD.predicateWithCountOfMatchAndIsBonusMatched().test(5, true)).isFalse(),
                () -> assertThat(LottoRanking.FIRST.predicateWithCountOfMatchAndIsBonusMatched().test(6, true)).isTrue()
        );
    }

    @DisplayName("로또 랭킹에 따른 상금(돈) 테스트")
    @ParameterizedTest(name = "로또 랭킹 {0} 에 따른 상금(돈) {1} 테스트")
    @CsvSource(value = {"MISS, 0", "THIRD, 1500000", "SECOND, 30000000", "FIRST, 2000000000"})
    void lottoRankingMoney(LottoRanking lottoRanking, int expect) {
        assertThat(lottoRanking.money()).isEqualTo(Money.valueOf(expect));
    }
}
