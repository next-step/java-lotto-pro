package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    Lotto lotto;

    @BeforeEach
    public void setup() {
        lotto = new Lotto();
    }

    @Test
    @DisplayName("로또 번호의 숫자가 6개인지 확인")
    public void validNumberCount() {
        assertThat(lotto.numbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 게임의 숫자가 모두 다른지 확인")
    public void differentValue() {
        assertThat(new HashSet<>(lotto.numbers()).size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 게임 출력 텍스트가 유효한 형식인지 확인")
    public void printNumbers() {
        lotto = new Lotto(1, 3, 17, 25, 39, 45);
        assertThat(lotto.printText()).isEqualTo("[1, 3, 17, 25, 39, 45]");
    }

    @Test
    @DisplayName("로또에 특정 번호가 포함되어 있는지 확인")
    public void containNumber() {
        lotto = new Lotto("11, 14, 24, 25, 37, 39");
        assertThat(lotto.contain(new LottoNo(11))).isTrue();
    }

    @Test
    @DisplayName("로또숫자가 6개 미만일 경우 검증")
    public void notValidLottoNoCount() {
        assertThatThrownBy(() -> new Lotto("11, 14, 24, 25, 37")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 로또숫자 형식이 잘못되었을 경우 검증")
    public void notValidLottoNumbers() {
        assertThatThrownBy(() -> new Lotto("a, 14, 24, 25, 37")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 로또 번호 검증")
    public void duplicatedLottoNumbers() {
        assertThatThrownBy(() -> new Lotto("1, 1, 14, 24, 25, 37")).isInstanceOf(IllegalArgumentException.class);
    }
}
