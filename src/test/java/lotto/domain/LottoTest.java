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
    @DisplayName("로또 번호를 문자열로 입력받아 생성")
    void create_문자열로_입력() {
        assertThat(new Lotto("1,2,3,4,5,6")).isNotNull();
    }

    @Test
    @DisplayName("로또 번호를 번호 리스트를 입력받아 생성")
    void create_숫자로_입력() {
        assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,3,3,4,4,4", ",", "1:2,3,4,5,600"})
    @DisplayName("잘못된 로또 번호 문자열 입력받아 생성 오류 테스트")
    void create_문자열_에러(String numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }

    @ParameterizedTest
    @MethodSource("generateNumbers")
    @DisplayName("잘못된 로또 번호들을 입력받아 생성 오류 테스트")
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

}
