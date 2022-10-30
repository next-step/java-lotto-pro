package lotto;


import lotto.service.LottoService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @ParameterizedTest
    @CsvSource(value = {"5000:5000","1000:1000","2000000000:2000000000"}, delimiter = ':')
    void readBuyAmount_정상_입력값_테스트(String input, int expected) {
        assertThat(lottoService.readBuyAmount(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"500","aaa","-10","0"})
    void readBuyAmount_입력값_유효성_테스트(String input) {
        assertThatThrownBy(() -> lottoService.readBuyAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> readWinningNumbers_정상_입력값_테스트() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6",new int[]{1,2,3,4,5,6}),
                Arguments.of("1,2,3,4,5,45",new int[]{1,2,3,4,5,45}),
                Arguments.of("3,11,22,34,41,45",new int[]{3,11,22,34,41,45})
        );
    }

    @ParameterizedTest
    @MethodSource
    void readWinningNumbers_정상_입력값_테스트(String input, int[] expected) {
        assertThat(lottoService.readWinningNumbers(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10","aaa","a,b,c,d,e,f",
            "1,2,3,4,5,5","1,2,3,4,5","1,2,3,4,5,6,7",
            "1,2,3,4,5,46","1,0,3,4,5,6","1,-1,2,3,4,5"})
    void readWinningNumbers_입력값_유효성_테스트(String input) {
        assertThatThrownBy(() -> lottoService.readWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
