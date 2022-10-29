package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("로또 6자리를 저장한다.")
    void save_lotto_numbers_test() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(12));
        numbers.add(new Number(23));
        numbers.add(new Number(34));
        numbers.add(new Number(43));
        numbers.add(new Number(44));

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto).isEqualTo(new Lotto(numbers));
    }
}
