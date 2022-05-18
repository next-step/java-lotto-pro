package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @ParameterizedTest
    @DisplayName("매치수량으로 LottoRank 를 반환한다")
    @CsvSource({"-1, MISS", "0, MISS", "1, MISS", "2, MISS", "3, FIFTH","4, FOURTH", "5, THIRD", "6, FIRST"})
    void of(int matchCount, LottoRank expected) {
        assertThat(LottoRank.of(matchCount)).isEqualTo(expected);
    }

}
