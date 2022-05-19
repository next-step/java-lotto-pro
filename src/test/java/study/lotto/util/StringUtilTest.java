package study.lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.LottoNumber;

class StringUtilTest {
    private static final String DELIMITER = ",";

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 공백없음")
    void splitAndParseInt() {
        int[] result = StringUtil.splitAndParseLottoNumber("1", DELIMITER).stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
        assertThat(result).containsExactly(1);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 공백없음")
    void splitAndParseInt_withoutSapce() {
        int[] result = StringUtil.splitAndParseLottoNumber("1,2,3,4", DELIMITER).stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 공백있음")
    void splitAndParseInt_withSpace() {
        int[] result = StringUtil.splitAndParseLottoNumber(" 1, 2 ,3 , 4 ", DELIMITER).stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 예외 - 숫자 외 문자 포함")
    void split_withNonNumber() {
        assertThatThrownBy(() -> StringUtil.splitAndParseLottoNumber(" 1, a , 4 ", DELIMITER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 예외 - 숫자 외 빈칸 포함")
    void split_withSpace() {
        assertThatThrownBy(() -> StringUtil.splitAndParseLottoNumber(" 1, , 4 ", DELIMITER))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
