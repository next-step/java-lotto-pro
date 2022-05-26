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
    @DisplayName("로또 생성시 입력된 숫자열과 동일한 값을 가지고 있는지 확인")
    @Test
    void lottoHasCorrectNumbers() {
        List<Integer> inputList = Arrays.asList(5, 41, 23, 7, 8, 1);
        Lotto lotto = new Lotto(inputList.stream().map(LottoNumber::new).collect(Collectors.toList()));

        assertThat(lotto.hasNumber(new LottoNumber(5))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(41))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(23))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(7))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(8))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(1))).isTrue();
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

    @DisplayName("로또번호 문자열을 통한 로또 객체 생성 테스트")
    @Test
    void lottoByString() {
        Lotto lotto = new Lotto("5, 41, 23, 7, 8, 1");

        assertThat(lotto.hasNumber(new LottoNumber(5))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(41))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(23))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(7))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(8))).isTrue();
        assertThat(lotto.hasNumber(new LottoNumber(1))).isTrue();
    }

    @DisplayName("6개 미만의 숫자가 포함된 문자열로 Lotto 생성시 Exception 확인")
    @Test
    void lottoByShortString() {
        assertThatThrownBy(() -> new Lotto("5, 41, 23, 7,")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자열로 Lotto 생성시 Exception 확인")
    @Test
    void lottoByAlphabetString() {
        assertThatThrownBy(() -> new Lotto("a, b, c, d, e, f")).isInstanceOf(IllegalArgumentException.class);
    }
}
