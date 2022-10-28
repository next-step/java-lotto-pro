package study.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import calculator.domain.Input;

public class InputTest {
    
    @Test
    @DisplayName("input_null값_테스트")
    public void input_test_null() {
        Input input = new Input(null);
        assertThat(input.split()).containsExactly("0");
    }
    
    @Test
    @DisplayName("input_빈값_테스트")
    public void input_test_empty() {
        Input input = new Input("");
        assertThat(input.split()).containsExactly("0");
    }
    
    @Test
    @DisplayName("input_쉼표_테스트")
    public void input_test_comma() {
        Input input = new Input("1,2,3");
        assertThat(input.split()).containsExactly("1","2","3");
    }
    
    @Test
    @DisplayName("input_콜론_테스트")
    public void input_test_colon() {
        Input input = new Input("1:2:3");
        assertThat(input.split()).containsExactly("1","2","3");
    }
    
    @Test
    @DisplayName("input_쉼표_콜론_테스트")
    public void input_test_comma_colon() {
        Input input = new Input("1,2:3");
        assertThat(input.split()).containsExactly("1","2","3");
    }
    
    @Test
    @DisplayName("input_커스텀_구분자_테스트")
    public void input_test_custom_delimiter() {
        Input input = new Input("//@\n1@2@3");
        assertThat(input.split()).containsExactly("1","2","3");
    }
}
