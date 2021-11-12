package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    @DisplayName("매개변수로 전달한 갯수와 동일한 수의 로또를 반환하는지 테스트")
    void generate() {
        Collection<Lotto> lottos = LottoGenerator.generate(3);
        assertThat(lottos).hasSize(3);
    }
}
