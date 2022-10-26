package study.step2;


import domain.StringAddCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

}
