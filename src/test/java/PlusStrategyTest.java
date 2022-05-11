import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.CustomDelimiterPlusStrategy;
import domain.DefaultDelimiterPlusStrategy;
import domain.EmptyPlusStrategy;
import domain.PlusStrategy;
import domain.PlusStrategyFactory;
import domain.SingleNumberPlusStrategy;
import exception.ExceptionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("더하기 식에 대한 테스트 코드")
class PlusStrategyTest {
    private PlusStrategyFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PlusStrategyFactory();
    }

    @Test
    @DisplayName("팩토리 클래스에 공백을 전달하면 EmptyPlusStrategy 를 반환하고 결과는 0이어야 한다")
    void blank_test() {
        String given = "";
        PlusStrategy plusStrategy = factory.getStrategy(given);

        assertTrue(plusStrategy instanceof EmptyPlusStrategy);
        assertThat(plusStrategy.result(given)).isEqualTo(0);
    }

    @Test
    @DisplayName("팩토리 클래스에 null을 전달하면 EmptyPlusStrategy 를 반환하고 결과는 0이어야 한다")
    void null_test() {
        String given = null;
        PlusStrategy plusStrategy = factory.getStrategy(given);

        assertTrue(plusStrategy instanceof EmptyPlusStrategy);
        assertThat(plusStrategy.result(given)).isEqualTo(0);
    }

    @DisplayName("팩토리 클래스에 숫자 하나를 문자열로 전달할 경우 SingleNumberPlusStrategy 가 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void single_number_test(String input) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.getClass()).isEqualTo(SingleNumberPlusStrategy.class);
    }

    @DisplayName("팩토리 클래스에 숫자 하나를 문자열로 전달할 경우 해당 문자가 숫자로 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void single_number_test_2(String input) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.result(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("팩토리 클래스에 숫자 두개를 컴마 구분자로 입력해 전달할 경우 DefaultDelimiterPlusStrategy 가 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "2,5", "3,4", "7,7"})
    void default_number_test(String input) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.getClass()).isEqualTo(DefaultDelimiterPlusStrategy.class);
    }

    @DisplayName("팩토리 클래스에 숫자 두개를 컴마 구분자로 입력해 전달할 경우 두 수의 합이 반환되어야 한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,5:7", "3,4:7", "7,7:14"}, delimiter = ':')
    void default_number_test_2(String input, String result) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.result(input)).isEqualTo(Integer.parseInt(result));
    }

    @DisplayName("팩토리 클래스에 숫자 두개를 콜론 구분자로 입력해 전달할 경우 DefaultDelimiterPlusStrategy 가 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1:2", "2:5", "3:4", "7:7"})
    void default_number_test_3(String input) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.getClass()).isEqualTo(DefaultDelimiterPlusStrategy.class);
    }

    @DisplayName("팩토리 클래스에 숫자 두개를 컴마 구분자로 입력해 전달할 경우 두 수의 합이 반환되어야 한다")
    @ParameterizedTest
    @CsvSource(value = {"1:2|3", "2:5|7", "3:4|7", "7:7|14"}, delimiter = '|')
    void default_number_test_4(String input, String result) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.result(input)).isEqualTo(Integer.parseInt(result));
    }

    @DisplayName("팩토리 클래스에 숫자 세개 이상을 콜론/컴마 구분자로 입력해 전달할 경우 DefaultDelimiterPlusStrategy 가 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "2:5:1,0", "3:4,2,8", "7:7,9"})
    void default_number_test_5(String input) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.getClass()).isEqualTo(DefaultDelimiterPlusStrategy.class);
    }

    @DisplayName("팩토리 클래스에 숫자 세개 이상을 콜론/컴마 구분자로 입력해 전달할 경우 모든 수의 합이 반환되어야 한다")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3|6", "2:5:1,0|8", "3:4,2,8|17", "7:7,9|23"}, delimiter = '|')
    void default_number_test_6(String input, String result) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.result(input)).isEqualTo(Integer.parseInt(result));
    }

    @DisplayName("팩토리 클래스에 커스텀 식을 전달할 경우 CustomDelimiterPlusStrategy 가 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//]\n3]2]3", "//*\n4*5*3"})
    void custom_number_test(String input) {
        PlusStrategy plusStrategy = factory.getStrategy(input);

        assertThat(plusStrategy.getClass()).isEqualTo(CustomDelimiterPlusStrategy.class);
    }

    @DisplayName("팩토리 클래스에 커스텀 식을 전달할 경우 정상적으로 모든 수의 합이 반환되어야 한다")
    @Test
    void custom_number_test_2() {
        String given_1 = "//;\n1;2;3";
        int expected_1 = 6;

        String given_2 = "//]\n3]2]3";
        int expected_2 = 8;

        String given_3 = "//_\n4_5_3";
        int expected_3 = 12;

        PlusStrategy plusStrategy = factory.getStrategy(given_1);
        PlusStrategy plusStrategy_2 = factory.getStrategy(given_2);
        PlusStrategy plusStrategy_3 = factory.getStrategy(given_3);

        assertThat(plusStrategy.result(given_1)).isEqualTo(expected_1);
        assertThat(plusStrategy_2.result(given_2)).isEqualTo(expected_2);
        assertThat(plusStrategy_3.result(given_3)).isEqualTo(expected_3);
    }

    @DisplayName("음수가 포함된 식을 전달할 경우 정상적으로 IllegalArgumentException 이 발생해야 힌다")
    @ParameterizedTest
    @ValueSource(strings = {"1:2:-3", "-2:5:1,0", "3:4,2,-8", "7:-7,9"})
    void negative_number_test(String input) {
        assertThatThrownBy(() -> factory.getStrategy(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.INVALID_EXPRESSION.getMessage());
    }

    @DisplayName("알 수 없는 형식의 식을 전달할 경우 IllegalArgumentException 이 발생해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,", "asdgg", "ee2,q"})
    void invalid_expression_test(String input) {
        assertThatThrownBy(() -> factory.getStrategy(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.INVALID_EXPRESSION.getMessage());
    }
}
