package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @ParameterizedTest
    @DisplayName("매치수량으로 LottoRank 를 반환한다")
    @CsvSource({
            "-1, false, MISS",
            "0, false, MISS", "0, true, MISS",
            "1, false, MISS", "1, true, MISS",
            "2, false, MISS", "2, true, MISS",
            "3, false, FIFTH", "3, true, FIFTH",
            "4, false, FOURTH", "4, true, FOURTH",
            "5, false, THIRD", "5, true, SECOND",
            "6, false, FIRST", "6, true, FIRST"})
    void of(int matchCount, boolean bonus, LottoRank expected) {
        assertThat(LottoRank.of(matchCount, bonus)).isEqualTo(expected);
    }
}
