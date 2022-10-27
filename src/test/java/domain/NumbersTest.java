package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void sum() {
        Numbers of = Numbers.of(new String[]{"1", "2", "3"});

        assertThat(of.sum()).isEqualTo(6);
    }
}