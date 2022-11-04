package lotto.lotto.domain;

import lotto.lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.lotto.domain.Lottos.DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.lotto.domain.Lottos.MAX_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 번호들")
class LottosTest {

    @DisplayName("6개 이상의 수를 추가 할 수 없다.")
    @Test
    void maxSize() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(6);
        lottoNumbers.add(7);
        assertThatThrownBy(() -> new Lottos(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MAX_SIZE + "를 초과할 수 없습니다.");
    }

    @DisplayName("중복된 수를 추가할 수 없다.")
    @Test
    void duplicate() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(5);
        assertThatThrownBy(() -> new Lottos(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }
}
