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
    @DisplayName("Lotto는 6개의 LottoNumber로 이루어져있다.")
    void Lotto_정상_테스트(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.lottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("Lotto는 6개의 LottoNumber로 이루어져있다 : 6개 초과시 오류")
    void Lotto_6개초과_테스트(){
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
            Lotto lotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto는 6개의 LottoNumber로 이루어져있다 : 6개 미달시 오류")
    void Lotto_6개미달_테스트(){
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            Lotto lotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("Lotto의 LottoNumber List는 중복이 불가하다.")
    void Lotto_중복불가_테스트(){
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
            Lotto lotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
