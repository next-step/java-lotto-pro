package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @DisplayName("로또번호 생성 테스트")
    @Test
    void createLottoTest() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(lotto)).isEqualTo(new Lotto(lotto));
    }

    @DisplayName("중복된 값이 있는 경우 테스트")
    @Test
    void duplicateLottoTest() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자가 아닌 경우 테스트")
    @Test
    void invalidSizeLottoTest() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}