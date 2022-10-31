package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    @DisplayName("전체 number를 더하는 테스트")
    void sumAllValueTest(){
        Numbers numbers = new Numbers();
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));
        assertThat(numbers.sumAllValue()).isEqualTo(new Number(6));
    }
}
