package study.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import calculator.domain.Result;
import calculator.util.Constants;

public class ResultTest {
    @Test
    @DisplayName("result_빈값_테스트")
    public void result_test_empty_number() {
        String[] numberStrArr = {""};
        Result result = new Result(numberStrArr);
        
        assertThatThrownBy(() -> result.sum()).hasMessage(Constants.ERR_VALUE_NOT_VALID);
    }
    
    @Test
    @DisplayName("result_null_테스트")
    public void result_test_null() {
        Result result = new Result(null);
        
        assertThatThrownBy(() -> result.sum()).hasMessage(Constants.ERR_VALUE_NOT_VALID);
    }
    
    @Test
    @DisplayName("result_문자열_테스트")
    public void result_test_not_number() {
        String[] numberStrArr = {"test"};
        Result result = new Result(numberStrArr);
        
        assertThatThrownBy(() -> result.sum()).hasMessage(Constants.ERR_VALUE_NOT_VALID);
    }
    
    @Test
    @DisplayName("result_음수_테스트")
    public void result_test_negative() {
        String[] numberStrArr = {"-1", "3"};
        Result result = new Result(numberStrArr);
        
        assertThatThrownBy(() -> result.sum()).hasMessage(Constants.ERR_NEGATIVE_VALUE);
    }
    
    @Test
    @DisplayName("result_더하기_테스트")
    public void result_test_sum() {
        String[] numberStrArr = {"1", "2", "3"};
        Result result = new Result(numberStrArr);
        
        assertThat(result.sum()).isEqualTo(6);
    }
}
