package lotto.domain;

import lotto.domain.factory.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    @DisplayName("1등 enum형을 입력하면 당첨횟수 2를 반환한다")
    void getWinningCount() {
        LottoResult lottoResult = new LottoResult(
                List.of(LottoFactory.create("1,2,3,4,5,6"), LottoFactory.create("1,2,3,4,5,6")),
                LottoFactory.create("1,2,3,4,5,6"));
        assertThat(lottoResult.getWinningCount(LottoRank.FIRST)).isEqualTo(2);
    }
}
