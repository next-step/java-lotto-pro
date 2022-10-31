package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottos.add(new Lotto(Arrays.asList(20,30,32,40,42,43)));
    }

    @Test
    @DisplayName("count 사용할때 내부 리스트 갯수를 리턴")
    void whenCount_thenNumber() {
        Lottos emptyLottos = new Lottos();

        assertThat(emptyLottos.count()).isZero();
        assertThat(this.lottos.count()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    @DisplayName("getLottoByIndex 사용할때 정상적인 인덱스가 아닐경우 에러")
    void givenOutOfIndex_whenGetLottoByIndex_thenThrow(int index) {
        assertThatThrownBy(() -> this.lottos.getLottoByIndex(index))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("존재하지않습니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1})
    @DisplayName("getLottoByIndex 사용할때 정상적인 인덱스인경우 로또 리턴")
    void givenValidIndex_whenGetLottoByIndex_thenLotto(int index) {
        Lotto lotto = this.lottos.getLottoByIndex(index);

        assertThat(lotto).isNotNull();
    }
}