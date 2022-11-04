package lotto.winning.domain;

import lotto.lotto.domain.fixture.LottoFixture;
import lotto.winning.fixture.WinningNumberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("매칭 횟수")
class MatchingCountTest {

    @DisplayName("일치 횟수 생성.")
    @Test
    void constructor() {
        assertThatNoException().isThrownBy(() -> new MatchingCount(LottoFixture.lottos(), WinningNumberFixture.당첨번호123456()));
    }
}
