package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 콜렉션 생성")
    void create() {
        Lottos lottos = Lottos.of(Arrays.asList(Lotto.of(LottoNumbers.generate("1,2,3,4,5,6"))));
        assertThat(lottos).isEqualTo(Lottos.of(Arrays.asList(Lotto.of(LottoNumbers.generate("1,2,3,4,5,6")))));
    }

    @Test
    @DisplayName("숫자 5를 입력받아 5개의 로또를 가진 로또 콜렉션 생성")
    void create_input_size_5() {
        Lottos lottos = Lottos.autoGenerateSizeOf(5);
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 콜렉션은 로또 콜렉션과 더하여 새로운 콜렉션을 생성한다")
    void add() {
        // given
        Lottos source = Lottos.autoGenerateSizeOf(5);
        Lottos target = Lottos.autoGenerateSizeOf(2);

        // when
        Lottos result = source.add(target);

        // then
        assertThat(result.size()).isEqualTo(7);
    }

}
