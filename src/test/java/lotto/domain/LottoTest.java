package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("Lotto 정상 생성")
    public void Lotto_정상생성() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 6, 10, 20, 34, 45));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.lottoNumbers()).containsExactly(1, 6, 10, 20, 34, 45);
    }

    @Test
    @DisplayName("Lotto 6개의 숫자로 초과 시, 예외가 발생해야 한다.")
    public void Lotto_6개_초과() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34, 45, 32));
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 6개의 숫자로 미만 시, 예외가 발생해야 한다.")
    public void Lotto_6개_미만() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34));
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 6개의 숫자 중 중복된 숫자가 있으면 예외가 발생해야 한다.")
    public void Lotto_숫자_중복() {
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34, 6));
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 내 6개의 숫자는 오름차순으로 정렬되어 있다.")
    public void Lotto_숫자_정렬() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 20, 10, 6, 34, 45));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.lottoNumbers()).containsExactly(1, 6, 10, 20, 34, 45);
    }
}
