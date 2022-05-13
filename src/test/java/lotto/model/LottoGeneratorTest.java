package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoGeneratorTest {


    @DisplayName("로또를 생성한다.")
    @Test
    void generateLotto(){
        Lotto lotto = LottoGenerator.generateLotto(Arrays.asList(1, 3, 15, 25, 30, 45));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 3, 15, 25, 30, 45)));
    }
}
