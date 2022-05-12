package study.step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
    @Nested
    @DisplayName("요구사항1")
    class Split_테스트 {
        @Test
        @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
        void split_테스트1() {
            String[] result = "1,2".split(",");
            assertThat(result).containsExactly("1", "2");
        }

        @Test
        @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
        void split_테스트2() {
            String[] result = "1".split(",");
            assertThat(result).containsExactly("1");
        }
    }

    @Nested
    @DisplayName("요구사항2")
    class Substring_테스트 {
        @Test
        @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
        void substring_테스트1() {
            String result = "(1,2)".substring(1, 4);
            assertThat(result).isEqualTo("1,2");
        }
    }

    @Nested
    @DisplayName("요구사항3")
    class CharAt_테스트 {
        private final String source = "abc";

        @Nested
        @DisplayName("charAt 메소드 성공테스트")
        class CharAt_성공테스트 {
            @Test
            @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
            void charAt_경계값_성공테스트() {
                assertThat(source.charAt(0)).isEqualTo('a');
                assertThat(source.charAt(2)).isEqualTo('c');
            }
        }

        @Nested
        @DisplayName("charAt 메소드 실패테스트")
        class CharAt_실패테스트 {
            private final String indexOutOfBoundsExceptionMessage = "index out of range";

            @Test
            @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면"
                    + " StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
            void charAt_경계값_실패테스트() {
                assertThatThrownBy(() -> source.charAt(-1)).isInstanceOf(IndexOutOfBoundsException.class)
                        .hasMessageContaining(indexOutOfBoundsExceptionMessage);
                assertThatThrownBy(() -> source.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
                        .hasMessageContaining(indexOutOfBoundsExceptionMessage);
            }
        }
    }
}
