package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    @Test
    @DisplayName("중복된 숫자가 있을 경우 exception이 발생한다.")
    void duplicate_exception_test() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(1);
            numbers.add(12);
            numbers.add(23);
            numbers.add(34);
            numbers.add(43);
            numbers.add(44);
            new Lotto(numbers);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
