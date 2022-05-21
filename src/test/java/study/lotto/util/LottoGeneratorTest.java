package study.lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.Lotto;
import study.lotto.LottoNumber;

class LottoGeneratorTest {
    private static final String NUMBER_DELIMITER = ",";

    @Test
    @DisplayName("여러개의 로또 생성")
    void generate() {
        final int genSize = 5;
        List<Lotto> lottos = LottoGenerator.generate(genSize);
        assertThat(lottos).hasSize(genSize);
    }

    @Test
    @DisplayName("여러개의 로또 생성 - 잘못된 숫자 - -1")
    void generate_exception_negative() {
        assertThatThrownBy(() -> LottoGenerator.generate(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 공백없음")
    void splitAndParseInt() {
        int[] result = LottoGenerator.splitAndParseLottoNumber("1", NUMBER_DELIMITER).stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
        assertThat(result).containsExactly(1);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 공백없음")
    void splitAndParseInt_withoutSapce() {
        int[] result = LottoGenerator.splitAndParseLottoNumber("1,2,3,4", NUMBER_DELIMITER).stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 공백있음")
    void splitAndParseInt_withSpace() {
        int[] result = LottoGenerator.splitAndParseLottoNumber(" 1, 2 ,3 , 4 ", NUMBER_DELIMITER).stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 예외 - 숫자 외 문자 포함")
    void split_withNonNumber() {
        assertThatThrownBy(() -> LottoGenerator.splitAndParseLottoNumber(" 1, a , 4 ", NUMBER_DELIMITER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 예외 - 숫자 외 빈칸 포함")
    void split_withSpace() {
        assertThatThrownBy(() -> LottoGenerator.splitAndParseLottoNumber(" 1, , 4 ", NUMBER_DELIMITER))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
