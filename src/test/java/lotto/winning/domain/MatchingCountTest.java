package lotto.winning.domain;

import common.vo.Count;
import lotto.lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static lotto.lotto.domain.fixture.LottoFixture.lottos;
import static lotto.lotto.domain.fixture.LottoFixture.로또123456;
import static lotto.winning.domain.MatchingCount.LOTTO_EXCEPTION_MESSAGE;
import static lotto.winning.domain.MatchingCount.WINNING_NUMBER_EXCEPTION_MESSAGE;
import static lotto.winning.fixture.WinningNumberFixture.당첨번호123456;
import static org.assertj.core.api.Assertions.*;

@DisplayName("매칭 횟수")
class MatchingCountTest {

    @DisplayName("일치 횟수 생성.")
    @Test
    void constructor() {
        assertThatNoException().isThrownBy(() -> new MatchingCount(lottos(), 당첨번호123456()));
    }

    @DisplayName("로또 null")
    @ParameterizedTest
    @NullAndEmptySource
    void lotto_null(List<Lotto> lottos) {
        assertThatThrownBy(() -> new MatchingCount(lottos, 당첨번호123456()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_EXCEPTION_MESSAGE);
    }

    @DisplayName("당첨번호 null")
    @ParameterizedTest
    @NullSource
    void winningNumber_null(WinningNumber winningNumber) {
        assertThatThrownBy(() -> new MatchingCount(lottos(), winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBER_EXCEPTION_MESSAGE);
    }

    @DisplayName("일치 횟수를 만족하는 로또의 갯수를 구한다.")
    @CsvSource({"6", "1"})
    void lottoCount(int machingCount, int expected) {
        assertThat(new MatchingCount(로또123456(), 당첨번호123456()).lottoCount(machingCount)).isEqualTo(new Count(expected));
    }
}
