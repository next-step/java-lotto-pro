package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 생성시 입력된 숫자열의 사이즈와 동일한 사이즈를 가진 로또 객체 생성 확인")
    @Test
    void lottoSize() {
        List<Integer> inputList = Arrays.asList(5, 41, 23, 7, 8, 1);
        Lotto result = new Lotto(inputList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        assertThat(result.size()).isEqualTo(inputList.size());
    }

    @DisplayName("로또 생성시 정의된 로또숫자 사이즈가 아닌경우 Exception 발생 확인")
    @Test
    void lottoWrongSize() {
        assertThatThrownBy(() -> new Lotto(
                Stream.of(1, 5, 10, 12, 20, 40, 3).map(LottoNumber::new).collect(Collectors.toList())));
    }

    @DisplayName("로또 생성시 숫자열을 empty list 로 입력할 경우 Exception 발생 확인")
    @Test
    void lottoEmptyList() {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>())).isInstanceOf(IllegalArgumentException.class);
    }
}
