package lotto.ui.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import lotto.domain.lotto.Matches;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

class WinningNumberMatchTest {
    @DisplayName("Matches에 대응되는 enum 값이 존재해야 한다.")
    @ParameterizedTest(name = "{0}에 대응되는 enum 값이 존재해야 한다.")
    @EnumSource(Matches.class)
    void Matches_대응(final Matches matches) {
        assertThatNoException()
                .isThrownBy(() -> WinningNumberMatch.valueOf(matches));
    }

    @ParameterizedTest(name = "{0}은 조회되지 않는다.")
    @EnumSource(value = WinningNumberMatch.class, names = "BLANK")
    void 꽝_조회_안됨(final WinningNumberMatch match) {
        assertThat(match.isDisplayed()).isFalse();
    }

    @DisplayName("꽝 이외엔 조회된다.")
    @ParameterizedTest(name = "{0}는 조회된다.")
    @EnumSource(value = WinningNumberMatch.class, names = "BLANK", mode = Mode.EXCLUDE)
    void 나머지_조회됨(final WinningNumberMatch match) {
        assertThat(match.isDisplayed()).isTrue();
    }

    @Test
    void 문자열_반환() {
        final String string = WinningNumberMatch.SIX.toStringWithCount(1);

        assertThat(string).isEqualTo("6개 일치 (2000000000원)- 1개");
    }
}
