package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Lottos;

@DisplayName("Lottos 클래스")
public class LottosTest {
    @DisplayName("생성자에 입력한 수만큼 로또 객체를 갖는 리스트를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {5, 3, 8})
    void has_Input_Size(final int input) {
        final Lottos lottos = new Lottos(input);
        assertThat(lottos.getLottosCount()).isEqualTo(input);
    }
}
