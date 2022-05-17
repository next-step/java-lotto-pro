package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {
    @Test
    @DisplayName("Lotto는 6개의 LottoNumber로 구성")
    void Lotto_정상_테스트(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.lottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("Lotto는 6개의 LottoNumber로 구성: 6개 초과시 오류")
    void Lotto_6개초과_테스트(){
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
            Lotto lotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto는 6개의 LottoNumber로 구성: 6개 미달시 오류")
    void Lotto_6개미달_테스트(){
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
            Lotto lotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("Lotto의 LottoNumber List는 중복 불가")
    void Lotto_중복불가_테스트(){
        assertThatThrownBy(() -> {
            List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5));
            Lotto lotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto의 LottoNumber List는 오름차순 정렬")
    void Lotto_정렬_테스트(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.lottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("Lotto는 다른 Lotto와 몇 개의 숫자가 일치하는지 비교할 수 있다.")
    void Lotto_비교_테스트(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto lotto = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers2);
        assertThat(lotto.countMatchedNumbers(lotto2)).isEqualTo(3);
    }

    @Test
    @DisplayName("Lotto는 LottoNumber를 포함하는지 비교할 수 있다.")
    void Lotto_포함_테스트(){
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertAll(
                () -> assertThat(lotto.match(new LottoNumber(1))).isTrue(),
                () -> assertThat(lotto.match(new LottoNumber(10))).isFalse()
        );
    }
}
