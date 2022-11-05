package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.fixture.LottoFixture.로또번호123456;
import static lotto.fixture.LottoFixture.로또번호123457;
import static lotto.domain.WinningNumber.WINNING_NUMBER;
import static lotto.fixture.WinningNumberFixture.당첨번호123456;
import static org.assertj.core.api.Assertions.*;

@DisplayName("당첨번호")
class WinningNumberTest {

    @DisplayName("6개 일치 갯수 판별")
    @ParameterizedTest
    @ValueSource(ints = {6})
    void winningNumberCount_six_matches(int expected) {
        assertThat(당첨번호123456().findMatchingCount(로또번호123456())).isEqualTo(expected);
    }

    @DisplayName("5개 일치 갯수 판별")
    @ParameterizedTest
    @ValueSource(ints = {5})
    void winningNumberCount_five_matches(int expected) {
        assertThat(당첨번호123456().findMatchingCount(로또번호123457())).isEqualTo(expected);
    }

    @DisplayName("6자리 미만일 수 없다.")
    @ParameterizedTest
    @MethodSource("size")
    void size(String[] numbers) {
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBER + "자리여야합니다.");
    }

    @DisplayName("중복된 수를 입력할 수 없다.")
    @ParameterizedTest
    @MethodSource("duplicate")
    void duplicateNumber(String[] numbers) {
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }

    @DisplayName("숫자만 입력 가능하다.")
    @ParameterizedTest
    @MethodSource("type")
    void type(String[] numbers) {
        assertThatThrownBy(() -> new WinningNumber(numbers))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("숫자만 입력 가능하다.")
    @ParameterizedTest
    @MethodSource("constructor")
    void constructor(String[] numbers) {
        assertThatNoException().isThrownBy(() -> new WinningNumber(numbers));
    }

    static Stream<Arguments> size() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6", "7"})
        );
    }

    static Stream<Arguments> duplicate() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "5"})
        );
    }

    static Stream<Arguments> type() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "x"})
        );
    }

    static Stream<Arguments> constructor() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6"})
        );
    }
}
