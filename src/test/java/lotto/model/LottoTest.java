package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또를 생성하여 toString 으로 검증.")
    @Test
    void lottoCreate() {
        Lotto lotto = new Lotto(new int[]{1,2,3,4,5,6});
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
