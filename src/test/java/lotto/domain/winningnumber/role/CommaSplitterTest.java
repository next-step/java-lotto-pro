package lotto.domain.winningnumber.role;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CommaSplitterTest {

    WinningNumberRole role = new CommaSplitter();

    @ParameterizedTest
    @DisplayName("당첨번호는 중복 된 값을 못가짐")
    @CsvSource(value = "1, 2, 3, 4, 5, 5:5", delimiter = ':')
    void duplicate(String winningNumber, int expected) {
        assertThat(role.createWinningNumber(winningNumber)).hasSize(expected);
    }

    @ParameterizedTest
    @DisplayName("공백이 있어도 쉼표로 split 하여 생성가능")
    @CsvSource(value = "1, 2, 3, 4, 5, 6:6", delimiter = ':')
    void split(String winningNumber, int expected) {
        assertThat(role.createWinningNumber(winningNumber)).hasSize(expected);
    }
}
