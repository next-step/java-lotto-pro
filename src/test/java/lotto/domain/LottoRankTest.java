package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoRankTest {
    @Test
    @DisplayName("파라미터로 전달된 값과 비교하고자 하는 ENUM의 속성이 일치한다.")
    void checkMatchValues() {
        assertAll(
            () -> {
                LottoRank first = LottoRank.FIRST;
                assertThat(first.getMatch()).isEqualTo(6);
                assertThat(first.hasBonus()).isFalse();
            },
            () -> {
                LottoRank second = LottoRank.SECOND;
                assertThat(second.getMatch()).isEqualTo(5);
                assertThat(second.hasBonus()).isTrue();
            }
        );
    }

    @Test
    @DisplayName("match와 hasBonus로 일치하는 ENUM값을 찾는다.")
    void checkFindEnum() {
        assertAll(
            () -> assertThat(LottoRank.find(5, true)).isEqualTo(LottoRank.SECOND),
            () -> assertThat(LottoRank.find(5, false)).isEqualTo(LottoRank.THIRD)
        );
    }
}