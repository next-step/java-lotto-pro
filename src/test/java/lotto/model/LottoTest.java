package lotto.model;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private final static int LOTTO_SIZE = 6;

    @DisplayName("로또를 생성하여 toString 및 size로 검증")
    @Test
    void lottoCreate() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 번호가 갯수가 맞지 않을때 나오는 에러 검증")
    @Test
    void lottoSizeUnmatchedError() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_SIZE_UNMATCHED);

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_SIZE_UNMATCHED);
    }

    @DisplayName("로또가 중복일때 나오는 에러 검증")
    @Test
    void lottoDuplicate() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 1, 1, 1, 1, 1));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_ERROR);
    }

    @DisplayName("로또객체 null, 빈값 생성 에러 검증")
    @Test
    void nullLotto() {
        assertThatThrownBy(() -> {
            new Lotto(null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NULL);

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList());
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NULL);
    }
}
