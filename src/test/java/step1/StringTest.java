package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.utils.StringUtil;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {
    @DisplayName("String 클래스의 split() 메서드는")
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
    @DisplayName("StringUtil 클래스의 substring() 메서드는")
    @Nested
    class Describe_StringUtil_Substring {
        @DisplayName("\"(1,2)\"을 값을 전달받았을 때")
        @Nested
        class Context_One_And_Two_With_Parentheses {
            @DisplayName("\"1,2\"을 반환한다.")
            @ParameterizedTest
            @CsvSource(value = {"(1,2):1,2"}, delimiter = ':')
            void it_Returns_String_Parentheses_Removed(final String input, final String expected) {
                final String result = StringUtil.substring(input);
                assertThat(result).isEqualTo(expected);
            }
        }
    }
    @DisplayName("String 클래스의 charAt() 메서드는")
    @Nested
    class Describe_CharAt {
        @DisplayName("\"abc\" 값을 전달받았을 때")
        @Nested
        class Context_One_And_Two_With_Parentheses {
            final String input = "abc";
            @DisplayName("charAt(0)을 하면")
            @Nested
            class And_Char_At_Zero {
                @DisplayName("\"a\"를 반환한다.")
                @Test
                void it_Returns_A() {
                    final char result = input.charAt(0);
                    assertThat(result).isEqualTo('a');
                }
            }
            @DisplayName("charAt(1)을 하면")
            @Nested
            class And_Char_At_One {
                @DisplayName("\"b\"를 반환한다.")
                @Test
                void it_Returns_B() {
                    final char result = input.charAt(1);
                    assertThat(result).isEqualTo('b');
                }
            }
            @DisplayName("charAt(2)을 하면")
            @Nested
            class And_Char_At_Two {
                @DisplayName("\"c\"를 반환한다.")
                @Test
                void it_Returns_C() {
                    final char result = input.charAt(2);
                    assertThat(result).isEqualTo('c');
                }
            }
            @DisplayName("charAt(3)을 하면 (위치값을 벗어나면)")
            @Nested
            class And_Char_At_Three {
                @DisplayName("StringIndexOutOfBoundsException이 발생한다.")
                @Test
                void it_Returns_StringIndexOutOfBoundsException() {
                    assertThatThrownBy(() -> {
                        final char result = input.charAt(3);
                    }).isInstanceOf(StringIndexOutOfBoundsException.class)
                            .hasMessageContaining("String index out of range: 3");
                }
            }
        }
    }
}
