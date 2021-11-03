package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private final static int LOTTO_SIZE = 6;

    @DisplayName("로또를 생성하여 toString 및 size로 검증.")
    @Test
    void lottoCreate() {
        Lotto lotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(lotto.size()).isEqualTo(LOTTO_SIZE);
    }
}
