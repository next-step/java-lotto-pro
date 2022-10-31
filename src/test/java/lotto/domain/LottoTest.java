package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    @DisplayName("자동 로또 생성")
    void create() {
        assertThat(new Lotto(LottoNumbers.generate())).isNotNull();
    }

    @Test
    @DisplayName("로또번호를 문자열로 입력받아 생성")
    void create_문자열로_입력() {
        assertThat(new Lotto("1,2,3,4,5,6")).isNotNull();
    }

    @Test
    @DisplayName("로또번호를 숫자리스트를 입력받아 생성")
    void create_숫자로_입력() {
        assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,3,3,4,4,4", ",", "1:2,3,4,5,600"})
    @DisplayName("잘못된 로또번호를 문자열로 입력받아 생성하면 오류가 발생한다.")
    void create_문자열_에러(String numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }

    @ParameterizedTest
    @MethodSource("generateNumbers")
    @DisplayName("잘못된 로또번호들을 숫자리스트로 입력받아 생성하면 오류가 발생한다.")
    void create_번호리스트_에러(List<Integer> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }

    static Stream<Arguments> generateNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 4)),
                Arguments.of(Arrays.asList(500)),
                Arguments.of(Arrays.asList(1, 1, 1, 1, 1, 1))
        );
    }

    @Test
    @DisplayName("두개의 같은 로또의 매치 카운터는 6이다")
    void match_6() {
        Lotto source = new Lotto("1,2,3,4,5,6");
        assertThat(source.match(new Lotto("1,2,3,4,5,6"))).isEqualTo(6);
    }

    @Test
    @DisplayName("완전히 서로 다른 번호를 가진 로또의 매치 카운터는 0이다")
    void match_0() {
        Lotto source = new Lotto("1,2,3,4,5,6");
        assertThat(source.match(new Lotto("7,8,9,10,11,12"))).isEqualTo(0);
    }

    @Test
    @DisplayName("1,2,3,4,5,6 의 번호를 가진 로또와 로또 번호 1의 매치는 참이다 ")
    void match_LottoNumber() {
        Lotto source = new Lotto("1,2,3,4,5,6");
        assertThat(source.match(LottoNumber.of(1))).isTrue();
    }

}
