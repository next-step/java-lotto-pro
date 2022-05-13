package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("StringUtils 클래스 테스트")
class StringUtilsTest {

    @DisplayName("isEmpty시 비었는지 여부 반환")
    @ParameterizedTest
    @CsvSource({
            ",true",
            "'',true",
            "' ',false",
            "a,false"
    })
    void isEmpty(String value, boolean expected) {
        assertThat(StringUtils.isEmpty(value)).isEqualTo(expected);
    }
}
