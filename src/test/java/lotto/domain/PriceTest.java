package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {

    @Test
    @DisplayName("로또 가격을 생성할 수 있다.")
    void create() {
        assertDoesNotThrow(() -> new Price(1_000L));
    }

    @Test
    @DisplayName("로또 가격은 1000원 단위로 생성할 수 있다.")
    void create_invalidUnitPrice() {
        assertThatThrownBy(() -> new Price(1_500L))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 가격은 1장 단위로 생성할 수 있다.")
    void create_invalidNumberOfUnits() {
        assertThatThrownBy(() -> new Price(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주어진 가격으로 로또를 몇 장 살 수 있는지 계산할 수 있다.")
    void calculateNumberOfUnits() {
        assertThat(new Price(14_000L).calculateNumberOfUnits()).isEqualTo(14);
    }
}
