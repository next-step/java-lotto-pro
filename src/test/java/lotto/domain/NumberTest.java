package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {

    @Test
    @DisplayName("로또 번호 정상 검증")
    public void numberTest() {
        assertThat(new Number(1)).isEqualTo(new Number(1));
    }

    @Test
    @DisplayName("로또 번호 범위 오류 검증")
    public void NumberRange() {
        assertThatThrownBy(() -> {
            new Number(99);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}
