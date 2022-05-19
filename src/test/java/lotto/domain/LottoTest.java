package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_생성() {
        assertThat(new Lotto(6, 5, 4, 3, 2, 1)).isNotNull();
    }

    @Test
    void 로또_자릿수부족() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_자릿수초과() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 6, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_중복() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3", "1,2,7,8,9,10:2", "1,7,8,9,10,11:1", "7,8,9,10,11,12:0"}, delimiter = ':')
    void 로또_비교(String numbers, int expected) {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto target = new Lotto(numbers);
        assertThat(lotto.matchCount(target)).isEqualTo(expected);
    }

    @Test
    void 로또_숫자_포함() {
        assertThat(new Lotto(1, 2, 3, 4, 5, 6).contains(Number.from(4))).isTrue();
    }

    @Test
    void 로또_숫자_미포함() {
        assertThat(new Lotto(1, 2, 3, 4, 5, 6).contains(Number.from(7))).isFalse();
    }
}
