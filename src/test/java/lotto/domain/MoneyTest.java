package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    @DisplayName("입력받은 문자열을 통해 금액을 생성한다.")
    void generate_test() {
        Money money = new Money("1000");
        assertThat(money).isEqualTo(new Money("1000"));
    }

    @Test
    @DisplayName("금액은 숫자 형식이어야 한다.")
    void format_test() {
        assertThatThrownBy(() -> {
            Money money = new Money("A");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액은 최소 1000원 이상이어야 한다.")
    void minimum_size_test() {
        assertThatThrownBy(() -> {
            Money money = new Money("900");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액은 1000원의 배수이어야 한다.")
    void size_test() {
        assertThatThrownBy(() -> {
            Money money = new Money("1800");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 주어졌을 때, 구매할 수 있는 로또의 수를 반환한다.")
    void get_count_test() {
        Money money = new Money("1000");
        assertThat(money.calculateLottoCount()).isEqualTo(1);
    }
}
