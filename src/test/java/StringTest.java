import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {

    @DisplayName("split() 메서드는")
    @Nested
    class Describe_split {

        @DisplayName("\"1,2\"을 값으로 가지고 있을 때")
        @Nested
        class Context_One_And_Two {

            final String input = "1,2";

            @DisplayName("1과 2를 원소로 가지는 String[]을 반환한다.")
            @Test
            void it_Returns_String_Array() {

                final String[] result = input.split(",");

                assertThat(result).containsExactly("1", "2");

            }

        }

        @DisplayName("\"1\"을 값으로 가지고 있을 때")
        @Nested
        class Context_One {

            final String input = "1";

            @DisplayName("1을 원소로 가지는 String[]을 반환한다.")
            @Test
            void it_Returns_String_Array() {

                final String[] result = input.split(",");

                assertThat(result).containsExactly("1");

            }

        }

    }

}
