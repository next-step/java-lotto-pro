package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 컨트롤러")
class LottoControllerTest {

    @DisplayName("문자 숫자 리스트 변환")
    @ParameterizedTest
    @MethodSource("convert")
    void convert(String[] text) {
        assertThat(LottoController.convert(text)).containsExactly(1, 2, 3, 4, 5, 6);
    }

    static Stream<Arguments> convert() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6"}, Arrays.asList(1, 2, 3, 4, 5, 6))
        );
    }
}
