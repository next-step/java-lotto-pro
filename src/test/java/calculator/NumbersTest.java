package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @Test
    @DisplayName("생성자에서 String 배열로 숫자가 주어지면 Integer 리스트로 변환하여 필드에 셋팅한다.")
    void Numbers_String배열_숫자() {
        String[] inputs = new String[] {"1", "2", "3"};

        assertThat(new Numbers(inputs))
                .hasFieldOrProperty("numbers")
                .hasFieldOrPropertyWithValue("numbers", Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("생성자 파라미터에 문자가 포함되는 경우 IllegalArgumentException 예외를 발생시킨다.")
    void Numbers_String배열_문자포함() {
        String[] inputs = new String[] {"1", "A", "3"};

        assertThatThrownBy(() -> {
            new Numbers(inputs);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 이외의 값은 입력할 수 없습니다!");
    }
}