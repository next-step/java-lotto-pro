package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.Fixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultTest {

    @ParameterizedTest
    @CsvSource(value = {
        "0.0:11,12,13,14,15,16",
        "0.0:1,12,13,14,15,16",
        "0.0:1,2,13,14,15,16",
        "5.0:1,2,3,14,15,16",
        "50.0:1,2,3,4,15,16",
        "1500.0:1,2,3,4,5,16",
        "30000.0:1,2,3,4,5,7",
        "2000000.0:1,2,3,4,5,6",
    }, delimiter = ':')
    @DisplayName("로또 번호 갯수가 일치하는지 확인할 수 있다.")
    void m(final double expected, final String numbers) {
        final Playslip playslip = new Playslip(
            Fixtures.createNumbers(
                Arrays
                    .stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            )
        );
        final Playslips playslips = new Playslips(Arrays.asList(playslip));
        final Result result = playslips.checkResult(Fixtures.winningNumbers);
        assertThat(result.calculateReturnOnInvestment()).isEqualTo(expected);
    }
}
