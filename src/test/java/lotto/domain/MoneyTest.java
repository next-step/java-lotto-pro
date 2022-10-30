package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    @DisplayName("돈은 양수여야 함")
    void test1() {
        assertThatThrownBy(() -> Money.of(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("살수 있는 로또의 갯수를 반환함")
    void calLottoTicketCount() {
        int count = Money.of(10000).calLottoTicketCount(1000);

        assertThat(count).isEqualTo(10);
    }
}