package study.step2;


import domain.StringAddCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;
    @BeforeEach
    void setup(){
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 split")
    public void 기본구분자_split(){
        String given = "1,2:3";
        String[] expectValue = {"1", "2", "3"};

        String[] result = stringAddCalculator.split(given);

        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("//와 \n에 위치하는 문자를 커스텀 구분자로 사용하여 split")
    public void 커스텀구분자_split(){
        String given = "//;\n1;2;3";
        String[] expectValue = {"1", "2", "3"};

        String[] result = stringAddCalculator.split(given);

        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("기본 구분자의 split과 sum을 검증")
    public void 기본구분자_sum(){
        String given = "1,2:3";
        int expectValue = 6;

        int result = stringAddCalculator.splitAndSum(given);

        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("커스텀 구분자의 split과 sum을 검증")
    public void 커스텀구분자_sum(){
        String given = "//;\n1;2;3";
        int expectValue = 6;

        int result = stringAddCalculator.splitAndSum(given);

        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("입력받은 문자열이 null 또는 공백이면 0을 리턴 검증")
    public void 입력문자열_null_또는_빈문자(){
        String nullCheckParameter = null;
        String emptyCheckParameter = "";
        int expectValue = 0;

        Assertions.assertAll(
                () -> assertThat(stringAddCalculator.splitAndSum(nullCheckParameter)).isEqualTo(expectValue)
                ,() -> assertThat(stringAddCalculator.splitAndSum(emptyCheckParameter)).isEqualTo(expectValue)
        );
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자 반환")
    public void 입력문자열_숫자하나(){
        String given = "3";
        int expectValue = 3;

        int result = stringAddCalculator.splitAndSum(given);

        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    public void 입력문자열_음수(){
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력받은 숫자 값이 음수 입니다");
    }

    @Test
    public void 입력문자열_숫자_이외의값(){
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("a,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자만 입력 가능 합니다.");
    }

}
