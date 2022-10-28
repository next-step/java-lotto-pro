package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoGeneratorTest {
    @DisplayName("주어진 숫자로 로또 티켓을 생성할 수 있다")
    @Test
    void create_test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket ticket = LottoTicket.create(
                numbers.stream()
                        .map(i -> LottoNumber.get(i))
                        .collect(Collectors.toList())
        );

        LottoTicket result = new ManualLottoGenerator(numbers).create();
        assertThat(result.containCount(ticket)).isEqualTo(6);
    }
}
