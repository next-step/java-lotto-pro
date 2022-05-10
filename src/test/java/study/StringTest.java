package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @DisplayName("요구사항 1")
    @Nested
    class RequirementV1 {
        @Test
        void split_with_delimiter(){
            String[] result = "1,2".split(",");

            assertThat(result).contains("1");
            assertThat(result).contains("2");
            assertThat(result).containsExactly("1", "2");
        }

        @Test
        void split_without_delimiter(){
            String[] result = "1".split(",");

            assertThat(result).contains("1");
            assertThat(result).containsExactly("1");
        }
    }

    @DisplayName("요구사항 2")
    @Nested
    class RequirementV2{
        @Test
        void substring(){
            String result = "(1,2)".substring(1, 4);
            assertThat(result).isEqualTo("1,2");
        }
    }

    @DisplayName("요구사항 3")
    @Nested
    class RequirementV3{
        @Test
        void charAt(){
            assertThatThrownBy(() -> {
                "abc".charAt(3);
            }).isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessage("String index out of range: 3");
        }
    }
}
