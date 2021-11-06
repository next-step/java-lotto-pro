package lotto.domain.number;

import lotto.exception.OutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchedCountTest {
    @DisplayName("정적팩토리 메서드를 이용하여 메서드를 생성하면 객체가 만들어진다.")
    @Test
    void create() {
        assertThat(MatchedCount.from(1)).isInstanceOf(MatchedCount.class);
    }

    @DisplayName("일치하는 개수가 음수이면 예외를 던진다.")
    @Test
    void exceptionTest1() {
        assertThatThrownBy(() -> MatchedCount.from(-1)).isInstanceOf(OutOfBoundException.class);
    }

    @DisplayName("일치하는 개수가 최대값을 초과하면 예외를 던진다.")
    @Test
    void exceptionTest2() {
        assertThatThrownBy(() -> MatchedCount.from(7)).isInstanceOf(OutOfBoundException.class);
    }

}
