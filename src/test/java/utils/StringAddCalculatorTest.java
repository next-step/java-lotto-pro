package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    void 빈_문자열을_입력할_경우_0을_반환한다(){
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void null_값을_입력할_경우_0을_반환한다(){
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

}
