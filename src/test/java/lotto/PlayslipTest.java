package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayslipTest {

    @ParameterizedTest
    @CsvSource(value = {
        "0:11,12,13,14,15,16",
        "1:1,12,13,14,15,16",
        "2:1,2,13,14,15,16",
        "3:1,2,3,14,15,16",
        "4:1,2,3,4,15,16",
        "5:1,2,3,4,5,16",
        "6:1,2,3,4,5,6"
    }, delimiter = ':')
    @DisplayName("로또 번호 갯수가 일치하는지 확인할 수 있다.")
    void contains(final int expected, final String numbers) {
        final Playslip playslip = new Playslip(
            Fixtures.createNumbers(
                Arrays
                    .stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            )
        );
        assertThat(playslip.contains(Fixtures.winningNumbers, expected)).isTrue();
    }
}
