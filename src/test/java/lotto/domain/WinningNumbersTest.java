package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.Fixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 당첨 번호와 보너스 번호 일급 컬렉션을 생성할 수 있다.")
    void create() {
        assertDoesNotThrow(() ->
            new WinningNumbers(Fixtures.winningNumbersWithoutBonusNumber, Fixtures.bonusNumber)
        );
    }

    @Test
    @DisplayName("로또 당첨 번호와 보너스 번호는 일치할 수 없다.")
    void create_invalidBonusNumber() {
        assertThatThrownBy(() ->
            new WinningNumbers(Fixtures.winningNumbersWithoutBonusNumber, new Number(1))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0:0:11,12,13,14,15,16",
        // "0:0:1,12,13,14,15,16",
        // "0:0:1,2,13,14,15,16",
        // "3:5000:1,2,3,14,15,16",
        // "4:50000:1,2,3,4,15,16",
        // "5:1500000:1,2,3,4,5,7",
        // "5:30000000:1,2,3,4,5,16",
        // "6:2000000000:1,2,3,4,5,6"
    }, delimiter = ':')
    @DisplayName("당첨 번호와 로또 번호를 비교한 후 등수를 알 수 있다.")
    void checkNumbers(final int matchCount, final long amount, final String numbers) {
        final PickedNumbers pickedNumbers =
            Fixtures.createNumbers(
                Arrays
                    .stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );
        assertAll(
            () -> assertThat(
                Fixtures.winningNumbers.checkNumbers(pickedNumbers).getMatchCount()
            ).isEqualTo(matchCount),
            () -> assertThat(
                Fixtures.winningNumbers.checkNumbers(pickedNumbers).getAmount()
            ).isEqualTo(new Price(amount))
        );
    }
}
