package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoTest {
    @Test
    @DisplayName("로또 6자리를 저장한다.")
    void save_lotto_numbers_test() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(12);
        numbers.add(23);
        numbers.add(34);
        numbers.add(43);
        numbers.add(44);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto).isEqualTo(new Lotto(numbers));
    }
}
