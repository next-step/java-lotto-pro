package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 콜렉션 생성")
    void create() {
        Lottos lottos = new Lottos(Arrays.asList(Lotto.of(LottoNumbers.generate("1,2,3,4,5,6"))));
        assertThat(lottos).isEqualTo(new Lottos(Arrays.asList(Lotto.of(LottoNumbers.generate("1,2,3,4,5,6")))));
    }

    @Test
    @DisplayName("숫자 5를 입력받아 5개의 로또를 가진 로또 콜렉션 생성")
    void create_input_size_5() {
        Lottos lottos = Lottos.autoGenerateSizeOf(5);
        assertThat(lottos.size()).isEqualTo(5);
    }

}
