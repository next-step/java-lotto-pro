package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void createLotto() {
        assertThat(new Lotto()).isNotEqualTo(new Lotto());
    }
}
