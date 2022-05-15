package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    Lotto lotto;

    @BeforeEach
    public void setup() {
        lotto = new Lotto();
    }

    @Test
    @DisplayName("로또 번호의 숫자가 6개인지 확인")
    public void validNumberCount() {
        assertThat(lotto.seeNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 게임의 숫자가 모두 다른지 확인")
    public void differentValue() {
        assertThat(new HashSet<>(lotto.seeNumbers()).size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 게임 출력 텍스트가 유효한 형식인지 확인")
    public void printNumbers() {
        lotto = new Lotto(1, 3, 17, 25, 39, 45);
        assertThat(lotto.printText()).isEqualTo("[1, 3, 17, 25, 39, 45]");
    }
}
