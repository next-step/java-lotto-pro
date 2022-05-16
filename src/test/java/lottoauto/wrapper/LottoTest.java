package lottoauto.wrapper;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 여섯개_숫자_입력_로또_생성() {
        List<Integer> sampleNumbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            sampleNumbers.add(i);
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }

        Lotto lotto = new Lotto(sampleNumbers);
        assertThat(lotto.toString()).isEqualTo(numbers.toString());
    }

    @Test
    void 숫자_미_입력_로또_생성() {
        List<Integer> sampleNumbers = new ArrayList<>();
        assertThatThrownBy(() -> new Lotto(sampleNumbers)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void 숫자_0_입력_로또_생성() {
        List<Integer> sampleNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            sampleNumbers.add(i);
        }
        assertThatThrownBy(() -> new Lotto(sampleNumbers)).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 숫자_모자란_입력_로또_생성() {
        List<Integer> randomNumber = new ArrayList<>();
        for (int i = 1 ; i < 4; i++) {
            randomNumber.add(i);
        }
        assertThatThrownBy(() -> new Lotto(randomNumber)).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    void 로또_생성() {
        assertThat((new Lotto()).toString()).contains("[", "]");
    }
}