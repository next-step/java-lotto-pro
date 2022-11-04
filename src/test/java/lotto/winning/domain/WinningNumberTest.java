package lotto.winning.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.lotto.domain.fixture.LottoFixture.로또번호123456;
import static lotto.lotto.domain.fixture.LottoFixture.로또번호123457;
import static lotto.winning.fixture.WinningNumberFixture.당첨번호123456;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨번호")
class WinningNumberTest {

    @DisplayName("6개 일치 갯수 판별")
    @Test
    void winningNumberCount_six_matches() {
        assertThat(당첨번호123456().matchCounts(로또번호123456())).isEqualTo(6);
    }

    @DisplayName("5개 일치 갯수 판별")
    @Test
    void winningNumberCount_five_matches() {
        assertThat(당첨번호123456().matchCounts(로또번호123457())).isEqualTo(5);
    }
}
