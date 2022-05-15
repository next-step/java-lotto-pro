package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoGeneratorTest {
    @Test
    @DisplayName("6자리 로또 번호(자동) 번호가 생성된다.")
    void checkGenerateAutoNumbers() {
        assertThat(new HashSet<>(LottoAutoGenerator.makeNumbers())).hasSize(6);
    }
}