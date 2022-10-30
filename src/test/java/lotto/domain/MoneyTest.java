package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTest {

    @Test
    @DisplayName("화폐 생성")
    void create() {
        assertThat(new Money(10000)).isEqualTo(new Money("10000"));
    }

    @Test
    @DisplayName("입력받은 화폐가 숫자인지 검증")
    void parseLong() {
        assertThatThrownBy(() -> {
            new Money("천 원");
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("화폐를 비교해서 크거나 같은지 확인")
    void greaterEqualThan() {
        Money source = new Money(2000);
        Money target = new Money(1000);
        assertTrue(source.greaterEqualThan(target));
    }

}
