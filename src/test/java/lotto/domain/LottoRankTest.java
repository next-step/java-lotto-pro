package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

    @DisplayName("일치하는 갯수에 따라서 순위를 알 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void rank(int matchCount) {

        assertThat(LottoRank.getRank(matchCount)).isInstanceOf(LottoRank.class);
    }

    @DisplayName("순위에 따라서 상금을 구할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"6:2000000000", "5:1500000", "4:50000", "3:5000", "2:0", "1:0", "0:0"}, delimiter = ':')
    void winning_price(int matchCount, int winningPrice) {

        LottoRank rank = LottoRank.getRank(matchCount);

        assertThat(rank.getWinningPrice()).isEqualTo(winningPrice);
    }

}
