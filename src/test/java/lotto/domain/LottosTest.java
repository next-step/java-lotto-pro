package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {


    @Test
    @DisplayName("로또 콜렉션 생성")
    void create() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(LottoNumbers.generate("1,2,3,4,5,6"))));
        assertThat(lottos).isEqualTo(new Lottos(Arrays.asList(new Lotto(LottoNumbers.generate("1,2,3,4,5,6")))));
    }

}
