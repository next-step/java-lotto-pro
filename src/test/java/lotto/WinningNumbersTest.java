package lotto;


import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoTest.numbersToLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    static Stream<Arguments> winningNumbers_validate_test() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", Arrays.asList(1,2,3,4,5,6)),
                Arguments.of("1,2,3,4,5,45",Arrays.asList(1,2,3,4,5,45)),
                Arguments.of("3,11,22,34,41,45",Arrays.asList(3,11,22,34,41,45))
        );
    }

    @ParameterizedTest
    @DisplayName("지난주 당첨번호 입력값이 유효성체크 통과하는지 확인")
    @MethodSource
    void winningNumbers_validate_test(String input, List<Integer> expected) {
        assertThat((new WinningNumbers(input)).isEqualNumberList(expected)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("지난주 당첨번호 입력값 유효성체크 통과 안되는거 확인")
    @ValueSource(strings = {"10","aaa","a,b,c,d,e,f",
            "1,2,3,4,5,5","1,2,3,4,5","1,2,3,4,5,6,7",
            "1,2,3,4,5,46","1,0,3,4,5,6","1,-1,2,3,4,5"})
    void winningNumbers_invalidate_test(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호와 보너스번호가 일치하는지 확인")
    void winningNumber_bonusNumber_duplicate_test() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1,2,3,4,5,6), new BonusNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
