package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constants.Matched;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Matched 클래스")
public class MatchedTest {
    @DisplayName("일치 갯수가 3이면 보너스번호 일치여부와 상관없이 THREE_MATCHED를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:true", "3:false"}, delimiter = ':')
    void threeMatched(final int count, final boolean bonusMatched) {
        final Matched matched = Matched.getByCountAndBonusMatched(count, bonusMatched);
        assertThat(matched).isEqualTo(Matched.THREE_MATCHED);
    }

    @DisplayName("일치 갯수가 4면 보너스번호 일치여부와 상관없이 FOUR_MATCHED를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"4:true", "4:false"}, delimiter = ':')
    void fourMatched(final int count, final boolean bonusMatched) {
        final Matched matched = Matched.getByCountAndBonusMatched(count, bonusMatched);
        assertThat(matched).isEqualTo(Matched.FOUR_MATCHED);
    }

    @DisplayName("일치 갯수가 5면 보너스번호가 일치하지 않으면 FIVE_MATCHED를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"5:false"}, delimiter = ':')
    void fiveMatchedAndBonusNotMatched(final int count, final boolean bonusMatched) {
        final Matched matched = Matched.getByCountAndBonusMatched(count, bonusMatched);
        assertThat(matched).isEqualTo(Matched.FIVE_MATCHED);
    }

    @DisplayName("일치 갯수가 5면 보너스번호가 일치하면 FIVE_AND_BONUS_MATCHED를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"5:true"}, delimiter = ':')
    void fiveMatchedAndBonusMatched(final int count, final boolean bonusMatched) {
        final Matched matched = Matched.getByCountAndBonusMatched(count, bonusMatched);
        assertThat(matched).isEqualTo(Matched.FIVE_AND_BONUS_MATCHED);
    }

    @DisplayName("일치 갯수가 6이면 보너스번호 일치여부와 상관없이 SIX_MATCHED를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"6:true", "6:false"}, delimiter = ':')
    void sixMatched(final int count, final boolean bonusMatched) {
        final Matched matched = Matched.getByCountAndBonusMatched(count, bonusMatched);
        assertThat(matched).isEqualTo(Matched.SIX_MATCHED);
    }
}
