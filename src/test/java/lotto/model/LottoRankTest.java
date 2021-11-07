package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @ParameterizedTest
    @EnumSource(names = {"FIVE_MATCHES"})
    void rankTest(LottoRank lottoRank) {
        assertThat(lottoRank).isEqualTo(LottoRank.valueOf(5));
    }
}
