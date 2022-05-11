package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void valid_로또_1개_생성() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(userLotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void invalid_로또_1개_생성_숫자개수() {
        assertThatThrownBy(() -> {
            Lotto newLotto = new Lotto(Arrays.asList(1, 2, 3));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않은 6개의 숫자를 입력해주세요.");
    }

    @Test
    void invalid_로또_1개_생성_숫자범위() {
        assertThatThrownBy(() -> {
            Lotto newLotto = new Lotto(Arrays.asList(1, 2, 3, 55, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~45의 숫자만 입력해주세요.");
    }
}