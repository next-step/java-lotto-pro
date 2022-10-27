package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("번호 자동 생성")
    public void testGenerate() {
        Lotto lotto = Lotto.generate();
        assertThat(lotto).isNotNull();
    }
}
