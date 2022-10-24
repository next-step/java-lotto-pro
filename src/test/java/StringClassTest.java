import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class StringClassTest {
    private String[] resultArray;
    private String resultString;
    private String input;

    @BeforeEach
    void setup() {
        resultArray = null;
        resultString = null;
        input = null;
    }

    @NullAndEmptyContainTest
    @DisplayName("String split 작동 테스트")
    void string_split_test() {
        // When
        input = "1,2";
        resultArray = input.split(",");

        // When & Then
        assumingThat(resultArray.length == 2, () -> {
            assertThat(resultArray).contains("1", "2");
        });
    }

    @NullAndEmptyContainTest
    @DisplayName("배열이 1일경우, 1가지 값만을 반환하는지 확인 테스트")
    void split_exactly_one_test() {
        // When
        input = "1";
        resultArray = input.split(",");

        // Then
        assertThat(resultArray).containsExactly("1");
    }

    @Test
    @DisplayName("substring을 사용한후 값을 반환하는 테스트")
    void substring_test() {
        // When
        input = "(1,2)";
        resultString = input.substring(1,4);

        // Then
        assertThat(resultString).isEqualTo("1,2");
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource(value = { "0=a", "1=b", "2=c" }, delimiter = '=')
    @DisplayName("특정 위치의 문자값을 가져오는 테스트")
    void chat_at_test(int index, char expected) {
        // When
        input = "abc";

        // Then
        assertThat(input.charAt(index)).isEqualTo(expected);
    }

    @Test
    @DisplayName("존재하지 않는 문자열을 찾을시, 예외를 발생시키는 테스트")
    void char_at_throw_exception_test() {
        //When
        input = "abc";

        assertThatThrownBy(() -> input.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
