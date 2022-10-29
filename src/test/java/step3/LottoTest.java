package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Lotto;
import step3.model.Number;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("중복된 숫자가 있을 경우 exception이 발생한다.")
    void duplicate_exception_test() {
        assertThatThrownBy(() -> {
            List<Number> numbers = new ArrayList<>();
            numbers.add(new Number(1));
            numbers.add(new Number(12));
            numbers.add(new Number(23));
            numbers.add(new Number(34));
            numbers.add(new Number(44));
            numbers.add(new Number(44));
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 6개가 아닌 경우 exception이 발생한다.")
    void size_exception_test() {
        assertThatThrownBy(() -> {
            List<Number> numbers = new ArrayList<>();
            numbers.add(new Number(1));
            numbers.add(new Number(12));
            numbers.add(new Number(23));
            numbers.add(new Number(34));
            numbers.add(new Number(44));
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
