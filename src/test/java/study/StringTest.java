package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("요구사항 1-1 : 1,2가 잘 분리 되는지 확인하는 테스트")
    public void divideTest() {
        String inputText = "1,2";
        String[] resultTexts = inputText.split(",");
        assertThat(resultTexts).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2 : 1을 ,로 split 하였을 때 분리 되는지 확인하는 테스트")
    public void divideTest2() {
        String inputText = "1";
        String[] resultTexts = inputText.split(",");
        assertThat(resultTexts).containsExactly("1");
    }

}
