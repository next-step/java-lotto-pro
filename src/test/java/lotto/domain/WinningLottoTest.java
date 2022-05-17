package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    void 보너스볼이_로또_번호들과_중복된다면_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() ->
                new WinningLotto("1, 2, 3, 4, 5, 6", "6")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource
    void 로또를_인자로_받아_보너스볼과_일치하는지_확인한다(WinningLotto winningLotto, boolean bonus) {
        // given
        Lotto lotto = Lotto.createWithNumberLetter("1, 2, 3, 4, 5, 7");
        // when
        boolean result = winningLotto.matchBonus(lotto);
        // then
        assertThat(result).isEqualTo(bonus);
    }

    static Stream<Arguments> 로또를_인자로_받아_보너스볼과_일치하는지_확인한다() {
        return Stream.of(
                Arguments.of(
                        new WinningLotto("1, 2, 3, 4, 5, 6", "7"), true
                ),
                Arguments.of(
                        new WinningLotto("1, 2, 3, 4, 5, 6", "8"), false
                )
        );
    }

}