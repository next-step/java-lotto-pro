package lotto.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {

    @Test
    @DisplayName("1 ~ 45 사이의 값을 입력 받아 당첨 번호를 생성한다.")
    void createWinningNumbers() {
        //given //when
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        //then
        assertThat(winningNumbers.getWinningNumbers()).hasSize(6);
    }

    @ParameterizedTest(name = "당첨 번호 범위: [{index}] {0}")
    @ValueSource(ints = {5, 7})
    @DisplayName("당첨 번호가 6개 보다 작거나 많은 경우 예외가 발생한다.")
    void validateSize(int size) {
        //given //when
        List<Integer> numbers = IntStream.rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toList());

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(numbers));
    }

    @Test
    @DisplayName("당첨 번호가 중복될 경우 예외가 발생한다.")
    void validateDuplication() {
        //given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(numbers));
    }
}