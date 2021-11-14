package lotto.model.enums;

import static lotto.model.enums.Rank.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RankTest {
    @ParameterizedTest
    @DisplayName("당첨번호와 매칭된 수와 보너스 번호 매칭여부가 주어질 때, 적절한 등수(Rank)를 반환하는지 테스트")
    @MethodSource("provideMatchCountAndExpectedRank")
    void valueOf(int countOfMatch, boolean matchBonus, Rank rank) {
        Rank actual = Rank.valueOf(countOfMatch, matchBonus);
        assertThat(actual).isEqualTo(rank);
    }

    private static Stream<Arguments> provideMatchCountAndExpectedRank() {
        return Stream.of(
            Arguments.of(6, false, FIRST),
            Arguments.of(5, true, SECOND),
            Arguments.of(5, false, THIRD),
            Arguments.of(3, true, FIFTH),
            Arguments.of(3, false, FIFTH),
            Arguments.of(1, false, MISS),
            Arguments.of(0, true, MISS)
        );
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 매칭된 수가 음수이거나 로또 번호 전체의 갯수보다 클 때 예외를 발생시키는지 테스트")
    @ValueSource(ints = {-1, 7})
    void valueOfByInvalidCountOfMatch(int countOfMatch) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Rank.valueOf(countOfMatch, false));
    }

    @Test
    @DisplayName("getRanksHavingWinningMoney()메서드가 실제로 당첨금을 가지고 있는 값들을 반환하는지 테스트")
    void getRanksHavingWinningMoney() {
        List<Rank> ranks = Rank.getRanksHavingWinningMoney();
        assertThat(ranks).allMatch(rank -> rank.getWinningMoney() > 0);
    }
}
