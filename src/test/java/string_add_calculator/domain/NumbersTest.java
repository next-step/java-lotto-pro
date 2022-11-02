package string_add_calculator.domain;

import org.junit.jupiter.api.Test;
import string_add_calculator.domain.Numbers;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    void sum() {
        Numbers of = Numbers.of(new String[]{"1", "2", "3"});

        assertThat(of.sum()).isEqualTo(6);
    }
}