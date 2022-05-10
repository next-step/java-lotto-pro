import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringTest {

    @Nested
    @DisplayName("문자열 split 테스트")
    class StringSplitTest {
        private static final String COMMA = ",";

        @DisplayName("문자열 \"(1,2)\" 를 \",\" 로 split 하면 1과 2로 정상적으로 분리되어야 한다")
        @Test
        void string_split_comma() {
            String given = "1,2";
            String[] values = given.split(COMMA);

            assertThat(values.length).isEqualTo(2);
            assertThat(values).contains("1", "2");
            assertThat(values).containsExactly("1", "2");
        }

        @DisplayName("문자열 \"1\"을 \",\" 로 split 하면 1만을 포함하는 배열이 반환되어야 한다")
        @Test
        void string_split_comma_2() {
            String given = "1";
            String[] values = given.split(COMMA);

            assertThat(values.length).isEqualTo(1);
            assertThat(values).contains("1");
            assertThat(values).containsExactly("1");
        }
    }

    @Nested
    @DisplayName("문자열 substring 테스트")
    class SubstringTest {
        private static final int START_INDEX = 0;

        @Test
        @DisplayName("문자열 \"(1,2)\" 를 substring() 을 이용해 () 를 제거하면 \"1,2\" 가 반환되어야 한다")
        void string_substring_test() {
            String given = "(1,2)";
            String result = given.substring(START_INDEX + 1, given.length() - 1);

            assertThat(result).isEqualTo("1,2");
        }
    }
}
